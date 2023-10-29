Fire Alarm System

This is a simple Java program for a fire alarm system that utilizes the Observer design pattern. It consists of classes for sending alerts, processing alerts, and notifying observers (light bulbs and speakers) based on the severity of the alerts.

Classes

Alert
The Alert class represents an alert, with two main properties:

severity: An enum representing the severity level of the alert, which can be WARN, ERROR, or HAZARD.
message: A string that contains the alert message.
The Alert class has getter methods to access these properties.

Severity
The Severity enum defines three severity levels:

WARN: Represents a warning.
ERROR: Represents an error.
HAZARD: Represents a hazardous situation.
FireAlarm
The FireAlarm class extends the Observable class, which is a part of the Observer design pattern. It's responsible for sending alerts to observers when an alert is triggered. The sendAlert method is used to send an alert to registered observers.

LightBulb
The LightBulb class implements the Observer interface, which allows it to receive and respond to alerts sent by the FireAlarm. It updates the state of the light bulb based on the severity of the alert. If the severity is HAZARD, it flashes a red light, and if it's WARN, it flashes an orange light.

Speaker
The Speaker class also implements the Observer interface to receive and process alerts sent by the FireAlarm. It announces the alert message if the severity is either WARN or HAZARD.