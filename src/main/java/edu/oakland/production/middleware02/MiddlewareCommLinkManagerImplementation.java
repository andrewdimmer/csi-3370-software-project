package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.helper.admin.LocationDataPoint;
/** 
* Change this
*
*/

public class MiddlewareCommLinkManagerImplementation implements MiddlewareCommLinkManager {

  private MiddlewareCommDatabaseInterface midDatabaseInterface;
  private MiddlewareGisManager gisManager;

  LocationDataPoint[] locations = new LocationDataPoint[0];

  public TrackData parseRfid(int rfid){

    TrackData trackData = new TrackData(locations);
    return trackData;
  }

  public MiddlewareCommLinkManagerImplementation(
      MiddlewareCommDatabaseInterface midDatabaseInterface,
      MiddlewareGisManager gisManager
  ) {
    if (midDatabaseInterface == null) {
      throw new IllegalArgumentException("midDatabaseInterface cannot be null");
    }
    this.midDatabaseInterface = midDatabaseInterface;

    if (gisManager == null) {
      throw new IllegalArgumentException("gisManager cannot be null");
    }
    this.gisManager = gisManager;
  }


}