# -*- coding: utf-8 -*-
import json


class RequestParser:
    logout = False

    def parse(self, payload):
        # Split payload into the two keywords.
        content = payload.split()
        request = content.pop(0)

        # Use JSON and return the new message.
        message = {
            'request': request,
            'content': ' '.join(content)
        }
        if message['request'] == 'logout':
            self.logout = True
        return json.dumps(message)
