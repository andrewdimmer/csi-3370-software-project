package edu.oakland.test.middleware01;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.database.DatabaseGisInterface;

public class DatabaseGisInterfaceStub implements DatabaseGisInterface {

  public void receiveStoreRequest(LocationDataPoint locationDataPoint) {
    
  }

  public String receiveModeRequest(String mode) {
    return mode;
  }

  public String receiveNextSatRequest(String currentSat) {
    return currentSat;
  }

}