package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public class DatabaseGisManagerStub implements DatabaseGisManager {

  public String passNextSatRequest(String currentSat) {
    return currentSat;
  }

  public LocationDataPoint getLocationDataPoint(int offset) {
    return null;
  }

  public void passStoreRequest(LocationDataPoint locationDataPoint) {
    
  }

  public String passModeRequest(String mode) {
    return "normal";
  }
}

