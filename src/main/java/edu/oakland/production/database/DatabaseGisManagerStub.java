package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public class DatabaseGisManagerStub implements DatabaseGisManager{

  public String passNextSatRequest(String currentSat) {
    return "";
  }

  public LocationDataPoint getLocationDataPoint(int offset) {
    return null;
  }
}

