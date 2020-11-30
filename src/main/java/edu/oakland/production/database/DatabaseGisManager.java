package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public interface DatabaseGisManager {

  public void passStoreRequest(LocationDataPoint locationDataPoint);
  
  public void passModeRequest(String mode);
  
  public String passNextSatRequest(String currentSat);
  
}
