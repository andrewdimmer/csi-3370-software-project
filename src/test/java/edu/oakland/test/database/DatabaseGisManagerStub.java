package edu.oakland.test.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.database.DatabaseGisManager;

public class DatabaseGisManagerStub implements DatabaseGisManager {

  private LocationDataPoint ldp;
  private String mode;

  public String passNextSatRequest(String currentSat) {
    return currentSat;
  }

  public LocationDataPoint getLocationDataPoint() {
    return ldp;
  }

  public void passStoreRequest(LocationDataPoint locationDataPoint) {
    ldp = locationDataPoint;
  }

  public void passModeRequest(String mode) {
    this.mode = mode;
  }

  public String getMode() {
    return mode;
  }
}

