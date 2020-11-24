package edu.oakland.production.database;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.admin.LocationDataPoint;

public interface DatabaseCommManager {

  public int passGetRfidRequest();

  public LocationDataPoint passGetLocationDataPointRequest(int offset);

  public TrackData passGetTrackDataRequest(int offset);

  public void passStoreTrackDataRequest(TrackData trackData);

  public String passGetModeRequest();

    
}
