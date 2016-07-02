// constants for pinnumbers 
const int buttonPin = 2;
const int ledOne = 9;
const int ledTwo = 10;
const int ledThree = 11;
const int ledFour = 12;
const int ledFive = 13;

// variable for button
int buttonState = 0;

void setup() {
    // prepare input and output
    pinMode(buttonPin, INPUT);

    pinMode(ledOne, OUTPUT);
    pinMode(ledTwo, OUTPUT);
    pinMode(ledThree, OUTPUT);
    pinMode(ledFour, OUTPUT);
    pinMode(ledFive, OUTPUT);

    // initial light values
    digitalWrite(ledOne, LOW);
    digitalWrite(ledTwo, LOW);
    digitalWrite(ledThree, LOW);
    digitalWrite(ledFour, LOW);
    digitalWrite(ledFive, LOW);
}

void loop() {
    buttonState = digitalRead(buttonPin);

    if (buttonState == LOW) {
        // turn on all lights
        digitalWrite(ledOne, HIGH);
        digitalWrite(ledTwo, HIGH);
        digitalWrite(ledThree, HIGH);
        digitalWrite(ledFour, HIGH);
        digitalWrite(ledFive, HIGH);
    }
    else {
        // return to default light values
        digitalWrite(ledOne, LOW);
        digitalWrite(ledTwo, LOW);
        digitalWrite(ledThree, LOW);
        digitalWrite(ledFour, LOW);
        digitalWrite(ledFive, LOW);
    }
}
