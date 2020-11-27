# UML Class Diagrams: edu.oakland.production.display02.DisplayCommManager

**Primary Owner:** Jessica Cortes, Display_02 Team SCRUM Master ([@jcortes18](https://github.com/jcortes18/))

**Secondary Owners:**

- Sydney Hill, Display_02 Team SCRUM Assistant Master ([@sydneyhill3901](https://github.com/sydneyhill3901/))
- Jonathan Chan, Display_02 Team SCRUM Integrator ([@Volter43](https://github.com/Volter43/))

## Purpose

This interface shall receive RFID number from DisplayComm2WayManager interface. The interface will evaluate the user request format and if it is the correct format then it will transmit the RFID number to MiddlewareCommInterface interface. If it is not correct, the use case will end. This interface will receive track data from MiddlewareCommInterface and will send the track data back to the DisplayComm2WayManager interface.

## Class UML Diagram

Below is a diagram of the DisplayCommManager interface itself:

![DisplayCommManager](./DisplayCommManager.svg)

View larger as [.png](./DisplayCommManager.png) or [.svg](./DisplayCommManager.svg)

## Direct Dependencies UML Diagram

Below is a diagram of the direct dependencies required by the DisplayCommManager interface:

![DisplayCommManager Direct Dependencies](./DisplayCommManager_DirectDependencies.svg)

View larger as [.png](./DisplayCommManager_DirectDependencies.png) or [.svg](./DisplayCommManager_DirectDependencies.svg)

## Complete Dependency Closure UML Diagram

Below is a diagram of the complete dependencies closure of the DisplayCommManager interface:

![DisplayCommManager Dependency Closure](./DisplayCommManager_Closure.svg)

View larger as [.png](./DisplayCommManager_Closure.png) or [.svg](./DisplayCommManager_Closure.svg)
