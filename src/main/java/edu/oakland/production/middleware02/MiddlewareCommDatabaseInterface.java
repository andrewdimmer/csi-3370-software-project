package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;

public interface MiddlewareCommDatabaseInterface {

  public int checkCurrentRfid();
  
  public String requestMode(); 
  
  public TrackData getTrackData();

  public void storeTrackData(TrackData trackData);

  public LocationDataPoint getLocationDataPoint(int offset);

} 
