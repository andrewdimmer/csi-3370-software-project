package edu.oakland.test.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.database.DatabaseGisManager;

public class DatabaseGisManagerStub implements DatabaseGisManager {

  public String passNextSatRequest(String currentSat) {
    return "";
  }

  public LocationDataPoint getLocationDataPoint(int offset) {
    return null;
  }

  public void passStoreRequest(LocationDataPoint locationDataPoint) {
    
  }

  public String passModeRequest(String mode) {
    return "";
  }
}

