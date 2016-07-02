# -*- coding: utf-8 -*-
import socket
from responseReceiver import ResponseReceiver
from requestSender import RequestSender
import sys
from time import sleep


class Client:
    def __init__(self, host, server_port):
        # Set up the socket connection to the server.  
        self.connection = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.host = host
        self.server_port = server_port
        self.receiver = ResponseReceiver(self, self.connection)
        self.sender = RequestSender(self, self.connection)
        self.logged_in = False
        self.run()

    def run(self):
        # Initiating the connection to the server.
        self.connection.connect((self.host, self.server_port))
        
        # Starting ResponseReceiver and RequestSender.
        self.receiver.start()
        self.sender.start()
       
    def disconnect(self):
        print 'Logging out...'
        # Give the server time to respond
        sleep(1)
        # Closing the connection between the receiver, sender and client
        self.connection.close()
        print 'Exiting...'
        sys.exit(0)

    def get_logged_in(self):
        return self.logged_in

if __name__ == '__main__':
    # This is the main method, which is run by typing "python client.py" in the command-window.
    client = Client('localhost', 9998)
