# -*- coding: utf-8 -*-
import SocketServer
import socket
import json
import re
from requestParser import RequestParser

# Variables that go across all ClientHandler objects
history = []
connectedClients = {}


class ClientHandler(SocketServer.BaseRequestHandler):
    def handle(self):
        self.ip = self.client_address[0]
        self.port = self.client_address[1]
        self.connection = self.request
        self.logged = False
        self.parser = RequestParser(self)

        # Send welcome message when client has connected
        msg_welcome = self.parser.make_response('info', 'Welcome! Type \'help\' for a list of commands.', 'server')
        self.connection.sendall(json.dumps(msg_welcome))

        # Loop that listens for messages from the client
        while True:
            try:
                received_string = self.connection.recv(4096)
                if received_string:
                    # Get dictionary request from client
                    payload = json.loads(received_string)

                    # Send request and get a response dictionary from requestParser
                    response = self.parser.parse(payload)

                    # Send response to client.

                    if response['response'] == 'info':
                        if re.search('logout successful', response['content'], re.IGNORECASE):
                            self.log_out()

                    if response['response'] == 'message':
                        # Add message to history
                        history.append(response)

                        # Send the response to all connected clients
                        for client, value in connectedClients.iteritems():
                            value.sendall(json.dumps(response))
                    else:
                        self.connection.sendall(json.dumps(response))
            except socket.error as msg:
                # try:
                #     self.connection.sendall(
                #         self.parser.make_response('error', 'An error has occurred:' + str(msg), 'server'))
                # except:
                if self.logged:
                    self.log_out()

    # Log the user in
    def log_in(self, username):
        self.username = username
        self.logged = True

        # Add username to list of users
        connectedClients[username] = self.connection

        # Send login message to all but the client logging in
        for client, value in connectedClients.iteritems():
            if client != self.username:
                msg_login = self.parser.make_response('info', self.username + ' has logged in.', 'server')
                value.sendall(json.dumps(msg_login))

        # Send history when logged in.
        hist = self.parser.make_response('history', history, 'server')
        self.connection.sendall(json.dumps(hist))

    # See if the client is logged in or not
    def get_logged(self):
        return self.logged

    # Log the user out
    def log_out(self):
        # Send login message to all but the client logging out
        for client, value in connectedClients.iteritems():
            if client != self.username:
                msg_logout = self.parser.make_response('info', self.username + ' has logged out.', 'server')
                value.sendall(json.dumps(msg_logout))

        # Remove from the list of users
        self.logged = False
        connectedClients.pop(self.username, None)

    # Get all names as a comma-separated string
    def get_names(self):
        li_names = []
        for client, value in connectedClients.iteritems():
            li_names.append(client)
        li_names.sort()
        names = ', '.join(li_names)
        return names


class ThreadedTCPServer(SocketServer.ThreadingMixIn, SocketServer.TCPServer):
    # Each client connected will have their own thread
    allow_reuse_address = True


if __name__ == '__main__':
    # Main method executed when you type 'python server.py' in the terminal.

    HOST, PORT = 'localhost', 9998
    print 'Server running...'

    # Set up and initiate the TCP server
    server = ThreadedTCPServer((HOST, PORT), ClientHandler)
    server.serve_forever()
