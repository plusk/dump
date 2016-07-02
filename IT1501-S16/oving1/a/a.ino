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

    // initial light colors
    digitalWrite(ledOne, LOW);
    digitalWrite(ledTwo, LOW);
    digitalWrite(ledThree, LOW);
    digitalWrite(ledFour, LOW);
    digitalWrite(ledFive, LOW);
}

void loop() {
    buttonState = digitalRead(buttonPin);

    if (buttonState == LOW) {
        digitalWrite(ledOne, HIGH);
        delay(1000);
        digitalWrite(ledOne, LOW);
        digitalWrite(ledTwo, HIGH);
        delay(1000);
        digitalWrite(ledTwo, LOW);
        digitalWrite(ledThree, HIGH);
        delay(1000);
        digitalWrite(ledThree, LOW);
        digitalWrite(ledFour, HIGH);
        delay(1000);
        digitalWrite(ledFour, LOW);
        digitalWrite(ledFive, HIGH);
        delay(1000);
        digitalWrite(ledFive, LOW);
    }
    else {
        digitalWrite(ledOne, LOW);
        digitalWrite(ledTwo, LOW);
        digitalWrite(ledThree, LOW);
        digitalWrite(ledFour, LOW);
        digitalWrite(ledFive, LOW);
    }
}
