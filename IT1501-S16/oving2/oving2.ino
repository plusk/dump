#include "PLab_PushButton.h"

const int buzz = 3;
const int led = 13;
const int buttonPin = 2;
const int touch = 10;

int touchValue = 0;

boolean toggle = false;

PLab_PushButton btn(buttonPin);

void setup() {
  pinMode(led, OUTPUT);
  pinMode(touch, INPUT);
}

void loop() {
  btn.update();

  int sensorValue = analogRead(A0);

  touchValue = digitalRead(touch);
  
  if(btn.pressed() && !toggle) {
    toggle = true;
  }
  else if (btn.pressed() && toggle) {
    toggle = false;
  }
  if(toggle){
    digitalWrite(led, HIGH);
    
    if(touchValue == HIGH) {
      tone(buzz, sensorValue + 500);
    }
    else if(touchValue == LOW) {
      noTone(buzz);
    }
  }
  else {
    digitalWrite(led, LOW);
  }
}
