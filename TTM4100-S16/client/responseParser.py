# -*- coding: utf-8 -*-
import json


class ResponseParser:
    def __init__(self):
        self.logged_in = False
        # Dictionary of all valid responses.
        self.possible_responses = {
            'error': self.parse_error,
            'info': self.parse_info,
            'message': self.parse_message,
            'history': self.parse_history
        }

    def parse(self, payload):
        payload = json.loads(payload)

        # Checks if response is in possible_responses.
        if payload['response'] in self.possible_responses:
            # Calls the appropriate method from possible_responses.
            return self.possible_responses[payload['response']](payload)
        else:
            # Response not valid
            return 'Server response not valid! In ResponseParser.parse()'

    # Methods for parsing the specific responses. 
    # These methods apply a format to the string we return. 
    def parse_error(self, payload):
        error_string = '[{}][{}]: {}'.format(payload['timestamp'],
                                             payload['sender'], payload['content'])
        return error_string

    def parse_info(self, payload):
        info_string = '[{}][{}]: {}'.format(payload['timestamp'],
                                            payload['sender'], payload['content'])
        return info_string

    def parse_message(self, payload):
        message_string = '[{}][{}]: {}'.format(payload['timestamp'],
                                               payload['sender'], payload['content'].encode('utf-8'))
        return message_string

    def parse_history(self, payload):
        history_string = '[{}][{}]: History:{}'.format(payload['timestamp'],
                                               payload['sender'], self.history_content_parser(payload['content']))
        # If history is received user is logged in.
        self.logged_in = True
        return history_string

    # Extra method for parsing the content of a history response. 
    def history_content_parser(self, content):
        content_as_string = ''
        for message in content:
            content_as_string += '\n\t' + self.parse_message(message)
        return content_as_string

