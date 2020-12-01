package edu.oakland.test.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;

/**
 * This class shall get the current rfid and set it in trackdata.
 */

public class MiddlewareCommLinkManagerStub implements MiddlewareCommLinkManager {
  
/**
 *
 * This class set the status message in track data to a string of Rfid
 *
 */

  public TrackData checkCurrentRfid(int rfid) {
    TrackData trackD = new TrackData(new LocationDataPoint[0]);
    trackD.setStatusMessage(String.valueOf(rfid));
    return trackD;

  }
    
}
