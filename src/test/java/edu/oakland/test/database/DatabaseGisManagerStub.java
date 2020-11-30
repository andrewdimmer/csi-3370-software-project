package edu.oakland.test.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.database.DatabaseGisManager;

public class DatabaseGisManagerStub implements DatabaseGisManager {

  private LocationDataPoint ldp;

  public String passNextSatRequest(String currentSat) {
    return currentSat;
  }

  public LocationDataPoint getLocationDataPoint() {
    return ldp;
  }

  public void passStoreRequest(LocationDataPoint locationDataPoint) {
    ldp = locationDataPoint;
  }

  public String passModeRequest(String mode) {
    return mode;
  }
}

