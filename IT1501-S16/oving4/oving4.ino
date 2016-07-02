#include <ZumoMotors.h>
#include <Pushbutton.h>
#include <QTRSensors.h>
#include <ZumoReflectanceSensorArray.h>

const int LED = 13;

// this might need to be tuned for different lighting conditions, surfaces, etc.
const int QTR_THRESHOLD = 200;
 
// these might need to be tuned for different motor types
const int REVERSE_SPEED = 300; // 0 is stopped, 400 is full speed
const int TURN_SPEED = 300;
const int FORWARD_SPEED = 300;

const int REVERSE_DURATION = 200; // ms
const int TURN_DURATION = 200; // ms
ZumoMotors motors;
Pushbutton button(ZUMO_BUTTON); // pushbutton on pin 12
const int NUM_SENSORS = 6;
unsigned int sensor_values[NUM_SENSORS];
ZumoReflectanceSensorArray sensors;
 
void setup() {
  sensors.init();
  button.waitForButton();
  motors.setSpeeds(FORWARD_SPEED, FORWARD_SPEED);
}
 
void loop() {
  sensors.read(sensor_values);
  if (sensor_values[0] < QTR_THRESHOLD) {
    // if leftmost sensor detects line, reverse and turn to the right
    motors.setSpeeds(-REVERSE_SPEED, -REVERSE_SPEED);
    delay(REVERSE_DURATION);
    motors.setSpeeds(TURN_SPEED, -TURN_SPEED);
    delay(TURN_DURATION + random(50));
    motors.setSpeeds(FORWARD_SPEED, FORWARD_SPEED);
  }
  else if (sensor_values[5] < QTR_THRESHOLD) {
    // if rightmost sensor detects line, reverse and turn to the left
    motors.setSpeeds(-REVERSE_SPEED, -REVERSE_SPEED);
    delay(REVERSE_DURATION);
    motors.setSpeeds(-TURN_SPEED, TURN_SPEED);
    delay(TURN_DURATION + random(50));
    motors.setSpeeds(FORWARD_SPEED, FORWARD_SPEED);
  }
}
