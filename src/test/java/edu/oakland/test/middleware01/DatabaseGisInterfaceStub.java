package edu.oakland.test.middleware01;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.database.DatabaseGisInterface;
import java.time.LocalDateTime;

public class DatabaseGisInterfaceStub implements DatabaseGisInterface {
  private LocationDataPoint locationDataPoint = new LocationDataPoint(0, 0, LocalDateTime.now());
  private String mode;
  
  public void receiveStoreRequest(LocationDataPoint locationDataPoint) {
    this.locationDataPoint = locationDataPoint;
  }

  public LocationDataPoint getLocation() {
    return locationDataPoint;
  }

  public void receiveModeRequest(String mode) {
    this.mode = mode;
  }

  public String getMode() {
    return mode;
  }

  public String receiveNextSatRequest(String currentSat) {
    return currentSat;
  }

}