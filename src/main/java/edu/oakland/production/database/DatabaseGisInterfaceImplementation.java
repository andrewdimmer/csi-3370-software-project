package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public class DatabaseGisInterfaceImplementation implements DatabaseGisInterface {

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

  public void receiveModeRequest(String mode) {
    manager.passModeRequest(mode);
  } 

  public String receiveNextSatRequest(String currentSat) {
    return manager.passNextSatRequest(currentSat);
  }

}
