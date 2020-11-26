package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;


public interface DatabasePersistentStorage {

  public int locateRfidData();

  public LocationDataPoint getLocationDataPoint(int offset);

  public void storeLocationDataPoint(LocationDataPoint locationDataPoint);

  public TrackData getTrackData(int offset);

  public void storeTrackData(TrackData trackData);

  public String getMode();

  public void storeMode(String mode);

  public String getNextSat(String currentSat);


}

