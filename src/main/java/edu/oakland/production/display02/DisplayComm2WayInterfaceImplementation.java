package edu.oakland.production.display02;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommManagerImplementation;
import java.lang.IllegalArgumentException;


public class DisplayComm2WayInterfaceImplementation implements DisplayComm2WayInterface {
  DisplayCommManagerImplementation commManager;
  
  /**
  * Creates a DisplayComm2WayInterfaceImplementation to receive the rfid.
  *
  * @param DisplayCommManagerImplementation: The class that DisplayComm2Way will pass RFID to. 
  *
  */
  public DisplayComm2WayInterfaceImplementation(DisplayCommManagerImplementation displayCommManager) {
    if (displayCommManager == null) {
      throw new IllegalArgumentException("cannot be null");
    }
    this.commManager = displayCommManager;
  }

  /**
  * Receives the rfid from DisplayCommInterface
  * before passing along.
  *
  * @return the TrackData
  */
  public TrackData receiveRfidRequest(int rfidNum) {

    return determineUserRequestFormat(rfidNum);
  }
  
  
  /**
  * Determine the rfid request format.
  *
  * @return the TrackData
  */
  private TrackData determineUserRequestFormat(int rfidNum) {

    return passRfidRequest(rfidNum);
  }
  
  
  /**
  * Passes the evaluated rfid along to DisplayCommManagerInterface.
  *
  * @return the TrackData
  */
  public TrackData passRfidRequest(int rfidNum) {

    return commManager.receiveRfid(rfidNum);
  }

  /**
  * returns rfid if requested.
  *
  * @return rfidNum
  */
  public int returnRfidNum(int rfidNum) {

    return rfidNum;
  }
}
