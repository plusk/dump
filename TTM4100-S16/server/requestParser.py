# -*- coding: utf-8 -*-
import re
import datetime


class RequestParser:
    def __init__(self, server):
        # List of valid requests.
        self.possible_requests = {
            'login': self.parse_login,
            'logout': self.parse_logout,
            'msg': self.parse_msg,
            'names': self.parse_names,
            'help': self.parse_help
        }
        self.server = server

    def parse(self, payload):
        # Determine what to do with the payload. 
        if self.server.get_logged():
            if payload['request'] in self.possible_requests:
                return self.possible_requests[payload['request']](payload)
            else:
                return self.make_response('error', 'That is not a valid request.', 'server')
        else:
            # Not logged in, so may only make a few requests. 
            if payload['request'] == 'login' or payload['request'] == 'help':
                return self.possible_requests[payload['request']](payload)
            elif payload['request'] in self.possible_requests:
                return self.make_response('error',
                                          'You\'re not logged in yet. Type \'help\' for a list of available commands.',
                                          'server')
            else:
                return self.make_response('error', 'That is not a valid request.', 'server')

    def parse_login(self, payload):
        if self.server.get_logged():
            return self.make_response('error', 'You\'re already logged in.', 'server')
        else:
            # Get names to check if that user already exists.
            names = self.server.get_names()
            names = names.split('\n')
            # Check if username contains invalid characters. 
            username = payload['content']
            re_username = re.sub('[^a-zA-Z0-9]', '', username)
            if username != re_username or not username:
                return self.make_response('error', 'That is not a valid username.', 'server')
            elif username in names:
                return self.make_response('error', 'That username is already taken.', 'server')
            else:
                self.server.log_in(username)
                return self.make_response('info', 'Login successful.', 'server')

    def parse_logout(self, payload):
        # Made fairly simple by having a unique logout response type. 
        return self.make_response('info', 'Logout successful.', 'server')

    def parse_msg(self, payload):
        # Make response based on username. 
        sender = self.server.username
        if payload['content'] == '':
            return self.make_response('error', 'You\'re not allowed to post an empty message.', 'server')
        return self.make_response('message', payload['content'], sender)

    def parse_names(self, payload):
        # Get names from the server.
        names = self.server.get_names()
        return self.make_response('info', names, 'server')

    def parse_help(self, payload):
        # Composite a list of available commands. 
        str_help = '\n\thelp'.ljust(19) + '- view commands'
        str_help += '\n\tlogin <username>'.ljust(19) + '- log in with the given username'
        if self.server.get_logged():
            str_help += '\n\tlogout'.ljust(19) + '- log out'
            str_help += '\n\tmsg <message>'.ljust(19) + '- send <message>'
            str_help += '\n\tnames'.ljust(19) + '- list of users'
        return self.make_response('info', str_help, 'server')

    # This method forms a response dictionary based on what its parameters. 
    def make_response(self, response, content, sender):
        dic = {
            'timestamp': datetime.datetime.now().time().strftime('%H:%M:%S'),
            'sender': sender,
            'response': response,
            'content': content
        }
        possible_responses = ['error', 'info', 'message', 'history']

        if response not in possible_responses:
            raise ValueError(dic['response'] + 'is not a valid response.')
        if response == 'message':
            dic['sender'] = sender
        else:
            dic['sender'] = 'server'
        return dic
