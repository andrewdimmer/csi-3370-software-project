package edu.oakland.production.display02;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommManager;
import java.lang.IllegalArgumentException;


public class DisplayComm2WayInterfaceImplementation implements DisplayComm2WayInterface {
  
  private DisplayCommManager commManager;
  
  /**
  * Creates a DisplayComm2WayInterfaceImplementation to receive the rfid.
  *
  * @param displayCommManager The class that DisplayComm2Way will pass RFID to. 
  *
  */
  public DisplayComm2WayInterfaceImplementation(DisplayCommManager displayCommManager) {
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
  private TrackData receiveRfidRequest(int rfidNum) {

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
}
