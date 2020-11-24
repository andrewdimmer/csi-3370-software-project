package edu.oakland.production.database;

import edu.oakland.helper.database;
import edu.oakland.helper.LocationDataPoint;

public interface DatabaseGisManager {
  public void passStoreRequest(LocationDataPoint locationDataPoint);
  
  public void passModeRequest(String mode);
  public String passNextSatRequest(String currentSat);
}