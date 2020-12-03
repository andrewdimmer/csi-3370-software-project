package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.admin.LocationDataPoint;

public interface MiddlewareCommDatabaseInterface {

  public int checkCurrentRfid();
  

  public String requestMode(); 
  
  public TrackData getTrackData();

  public LocationDataPoint getLocationDataPoint(int offset);



  
  
  
} 