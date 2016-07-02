#include "PLab_PushButton.h"
#include <Servo.h>

// servo object
Servo myservo;

// servo position
int pos = 0;

const int buttonPin = 2;
const int green = 3;
const int red = 4;

boolean onoff = false;
boolean closed = false;

PLab_PushButton btn(buttonPin);

void setup() {
  pinMode(green, OUTPUT);
  pinMode(red, OUTPUT);

  digitalWrite(green, LOW);
  digitalWrite(red, LOW);

  // attach servo on pin 6 to servo object
  myservo.attach(6);

  myservo.write(pos);
}

void loop() {
  btn.update();
  int lightVal = analogRead(A0);
  if(btn.pressed() && !onoff) {
    onoff = !onoff;
  }
  else if (btn.pressed() && onoff) {
    onoff = !onoff;
    digitalWrite(green, LOW);
    digitalWrite(red, LOW);
  }
  if(onoff){
    if(lightVal >= 75) {
      closed = false;
      digitalWrite(green, HIGH);
      digitalWrite(red, LOW);
      delay(500);
    }
    else if(lightVal < 75) {
      closed = true;
      digitalWrite(green, LOW);
      digitalWrite(red, HIGH);
      delay(500);
    }
    
    if(!closed){
      pos = 0;
      myservo.write(pos);
    }
    else if(closed){
      pos = 90;
      myservo.write(pos);
    }
  }
}
