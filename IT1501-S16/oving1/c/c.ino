// constants for pinnumbers 
const int buttonPin = 2;
const int carRed = 13;
const int carYel = 12;
const int carGre = 11;
const int manRed = 10;
const int manGre = 9;

// variable for button
int buttonState = 0;

void setup() {
    // prepare input and output
    pinMode(buttonPin, INPUT);

    pinMode(carGre, OUTPUT);
    pinMode(carRed, OUTPUT);
    pinMode(carYel, OUTPUT);
    pinMode(manGre, OUTPUT);
    pinMode(manRed, OUTPUT);

    // initial light colors
    digitalWrite(carGre, HIGH);
    digitalWrite(manRed, HIGH);
}

void loop() {
    buttonState = digitalRead(buttonPin);

    if (buttonState == LOW) {
        delay(1000);
        digitalWrite(carGre, LOW);
        digitalWrite(carYel, HIGH);
        delay(1000);
        digitalWrite(carYel, LOW);
        digitalWrite(carRed, HIGH);
        delay(2000);
        digitalWrite(manRed, LOW);
        digitalWrite(manGre, HIGH);
        delay(5000);
        digitalWrite(manGre, LOW);
        digitalWrite(manRed, HIGH);
        delay(2000);
        digitalWrite(carYel, HIGH);
        delay(1000);
        digitalWrite(carYel, LOW);
        digitalWrite(carRed, LOW);
        digitalWrite(carGre, HIGH);
    }
    else {
        digitalWrite(carGre, HIGH);
        digitalWrite(carRed, LOW);
        digitalWrite(carYel, LOW);
        digitalWrite(manGre, LOW);
        digitalWrite(manRed, HIGH);
    }
}
