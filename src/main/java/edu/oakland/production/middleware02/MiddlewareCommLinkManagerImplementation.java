package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;


public class MiddlewareCommLinkManagerImplementation implements MiddlewareCommLinkManager {

  private MiddlewareCommDatabaseInterface midDatabaseInterface;
  private MiddlewareGisManager gisManager;

  private float calculateLocationData() {
    
    return 1;
  } 

  private float calculateTrackData() {

    return 1;
  }

/**
 * sets locationdatapoint[] into object called locations.
 */

  LocationDataPoint[] locations = new LocationDataPoint[0];
/**
 * we parserfid to get locationdatapoint.
 */
  public TrackData parseRfid(int rfid) {

    TrackData trackData = new TrackData(locations);
    return trackData;
  }

    /**
     * MiddlewareComLinkManagerImplementaions takes paraameter of Gismanager and Midatabaseinterface. 
    */

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