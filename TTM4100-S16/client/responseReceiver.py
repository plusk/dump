# -*- coding: utf-8 -*-
from threading import Thread
from responseParser import ResponseParser


class ResponseReceiver(Thread):
    def __init__(self, client, connection):

        # Properly initializing the thread object.
        super(ResponseReceiver, self).__init__()
        self.daemon = True # Flagging thread as daemon
        self.client = client
        self.connection = connection
        self.parser = ResponseParser()

    def run(self):
        while True:
            response_string = self.connection.recv(4096)
            # Check if received response.
            if response_string:
                # Makes string out of response and prints to console.
                print '{}'.format(self.parser.parse(response_string))

                if self.parser.logged_in:
                    self.client.logged_in = True