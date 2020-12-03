package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;

public class MiddlewareCommDatabaseInterfaceImplementation implements 
      MiddlewareCommDatabaseInterface {

  private DatabaseCommInterface databaseCommInterface;
  
  /**
   * The constructor for MiddlewareCommDatabaseInterfaceImplementation.
   */
  public MiddlewareCommDatabaseInterfaceImplementation(
      DatabaseCommInterface databaseCommInterface
  ) {
    if (databaseCommInterface == null) {
      throw new IllegalArgumentException("databaseCommInterface cannot be null");
    }
        
    this.databaseCommInterface = databaseCommInterface;
  }
  
  public int checkCurrentRfid() {
    return databaseCommInterface.receiveGetRfidRequest();
  } 
      
  public String requestMode() {
    return databaseCommInterface.receiveGetModeRequest();
  }

  public TrackData getTrackData() {
    int offset = 0;
    return databaseCommInterface.receiveGetTrackDataRequest(offset);
  }

  public LocationDataPoint getLocationDataPoint(int offset) {
    return databaseCommInterface.receiveGetLocationDataPointRequest(offset);
  }


}
