package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterfaceImplementation;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;
import edu.oakland.production.database.DatabaseCommInterface;


public class MiddlewareCommLinkManagerImplementation implements MiddlewareCommLinkManager {

  private MiddlewareCommDatabaseInterface midDatabaseInterface;
  private MiddlewareGisManager gisManager;
  //private LocationDataPoint[] locationDataPoint = new LocationDataPoint();

  /**
   * sets locationdatapoint[] into object called locations.
  */

  /**
   * we parserfid to get locationdatapoint.
  */

  /**
   * MiddlewareComLinkManagerImplementaions takes in Gismanager and Midatabaseinterface. 
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

  public TrackData parseRfid(int rfid) {
    //if (midDatabaseInterface.checkCurrentRfid() == midDatabaseInterface()){
      //gisManager.storeLocationDataPoint();
     // midDatabaseInterface.
     return null;
    
  }

  
  private float calculateLocationData() {
    gisManager.storeLocationDataPoint();
    //if (midDatabaseInterface.checkCurrentRfid() == )
    if (midDatabaseInterface.requestMode() == "normal"){

    }
    else {
      //TrackData trackData = new TrackData(midDatabaseInterface.getTrackData());
      midDatabaseInterface.getTrackData();
    }
    float fL = (float) 1.111;
    return fL;
  } 

  //private float calculateTrackData() {
    
  //}




}