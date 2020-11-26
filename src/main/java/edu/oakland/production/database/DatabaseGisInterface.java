package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public interface DatabaseGisInterface {

  public void receiveStoreRequest(LocationDataPoint locationDataPoint);

  public String receiveModeRequest(String mode); 

  public String receiveNextSatRequest(String currentSat);

}
