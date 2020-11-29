package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.database.DatabaseGisManagerStub;

public class DatabaseGisInterfaceClass {

  DatabaseGisManager manager;

  public DatabaseGisInterfaceClass(DatabaseGisManager m) {
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
