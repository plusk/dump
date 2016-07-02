# -*- coding: utf-8 -*-
from threading import Thread
from requestParser import RequestParser 


class RequestSender(Thread):

    def __init__(self, client, connection):
        super(RequestSender, self).__init__()
        self.client = client
        self.connection = connection
        self.parser = RequestParser()

    def run(self):
        # Wait for user input.
        while True:
            message = raw_input()
            if message:
                msg_parsed = self.parser.parse(message)
                if msg_parsed is not None:
                    self.connection.send(msg_parsed)

                    if self.parser.logout and self.client.get_logged_in():
                        self.client.disconnect()
