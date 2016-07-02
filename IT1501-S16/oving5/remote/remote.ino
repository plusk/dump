#include "PLab_PushButton.h"
#include <SoftwareSerial.h>
#include <PLabBTSerial.h>

const int pinForward = 10;
const int pinBackward = 7;
const int pinLeft = 8;
const int pinRight = 9;

#define rxPin 2
#define txPin 3
#define keyPin 4
#define pwrPin 5

const int led = 13;

PLab_PushButton btnForward(pinForward);
PLab_PushButton btnBackward(pinBackward);
PLab_PushButton btnLeft(pinLeft);
PLab_PushButton btnRight(pinRight);

PLabBTSerial btSerial(txPin, rxPin);

void setup()
{
  pinMode(led, OUTPUT);
  digitalWrite(led, LOW);
  
  btSerial.begin(9600);
  Serial.begin(9600);
}

void loop() {
  
  
  btnForward.update();
  btnBackward.update();
  btnLeft.update();
  btnRight.update();
  
  if(btnForward.pressed()){
    btSerial.write("FORWARD\n\r");
  }
  else if(btnBackward.pressed()){
    btSerial.write("BACKWARD\n\r");
  }
  else if(btnLeft.pressed()){
    btSerial.write("LEFT\n\r");
  }
  else if(btnRight.pressed()){
    btSerial.write("RIGHT\n\r");
  }

  // this way it only moved when button is held
  if (btnForward.released()) {
    btSerial.write("STOP\n\r");
  };
  if (btnBackward.released()) {
    btSerial.write("STOP\n\r");
  };

  int availableCount = btSerial.available();
  if (availableCount > 0) {
    char text[100];
    btSerial.read(text, availableCount);
    readCommand(text);
  }
}

void readCommand (char *text) {
  Serial.println(text);
}


   
