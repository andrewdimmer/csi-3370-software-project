package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public class DatabaseGisInterfaceImplementation {

  DatabaseGisManager manager;

  /**
   * Creates an database interface to middleware
   * to provide methods for managing GIS info.
   *
   * @param m an instance of the DatabaseGisManagerImplementation class.
   */
  public DatabaseGisInterfaceImplementation(DatabaseGisManager m) {
    if (m == null) {
      throw new IllegalArgumentException("manager cannot be null");
    }
    manager = m;
  }

  public void receiveStoreRequest(LocationDataPoint locationDataPoint) {
    manager.passStoreRequest(locationDataPoint);
  }

  public String receiveModeRequest(String mode) {
    return manager.passModeRequest(mode);
  } 

  public String receiveNextSatRequest(String currentSat) {
    return manager.passNextSatRequest(currentSat);
  }

}
