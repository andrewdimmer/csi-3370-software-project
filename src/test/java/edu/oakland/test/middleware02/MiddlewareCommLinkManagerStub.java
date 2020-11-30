package edu.oakland.test.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;


public class MiddlewareCommLinkManagerStub implements MiddlewareCommLinkManager {
  public TrackData checkCurrentRfid(int rfid) {
    TrackData trackD = new TrackData(new LocationDataPoint[0]);
    trackD.setStatusMessage(String.valueOf(rfid));
    return trackD;

  }
    
}
