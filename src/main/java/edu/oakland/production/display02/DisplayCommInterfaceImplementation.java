package edu.oakland.production.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayCommInterface;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import java.lang.IllegalArgumentException;

/**
* This class receives the rfid, evaluates it,
* then passes it along to Comm2Way.
*
*/
public class DisplayCommInterfaceImplementation implements DisplayCommInterface{

  private DisplayComm2WayInterface comm2Way;

  /**
  * Creates a DisplayCommInterfaceImplementation to receive the rfid.
  * param DisplatComm2WayInterface: The class that DisplayCommInterface will pass the rfid to.
  *
  */
  public DisplayCommInterfaceImplementation(DisplayComm2WayInterface displayComm2WayInterface) {
    if (displayComm2WayInterface == null) {
      throw new IllegalArgumentException("processor cannot be null");
    }
    this.comm2Way = displayComm2WayInterface;
  }

  /**
  * Receives the rfid from User
  * before passing along to Comm2way.
  *
  * @return the TrackData
  */
  public TrackData receiveRfidRequest(int rfidNum) {
    return comm2Way.passRfidRequest(rfidNum);
  }
}

