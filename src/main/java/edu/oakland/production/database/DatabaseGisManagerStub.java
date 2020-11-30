package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public class DatabaseGisManagerStub implements DatabaseGisManager {

  private LocationDataPoint ldp;

  public String passNextSatRequest(String currentSat) {
    return currentSat;
  }

  public LocationDataPoint getLocationDataPoint(int offset) {
    if (offset = 0) {
      return ldp;
    }
    return null;
  }

  public void passStoreRequest(LocationDataPoint locationDataPoint) {
    ldp = locationDataPoint;
  }

  public String passModeRequest(String mode) {
    return mode;
  }
}

