package edu.oakland.test.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommInterface;

/**
* Stub Method of DisplayComm2WayInterface.
* Used solely for testing.
*/
public class DisplayComm2WayInterfaceStub implements DisplayComm2WayInterface {

  private TrackData trackData;
  
  public DisplayComm2WayInterfaceStub(TrackData trackData) {
    this.trackData = trackData;
  }

  /**
  * Stub method, recieves the rfid
  * and returns a blank TrackData.
  */
  public TrackData passRfidRequest(int rfid) {
    trackData.setStatusMessage(String.valueOf(rfid));
    return trackData;
  }
}
