package edu.oakland.test.middleware01;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.database.DatabaseGisInterface;
import java.time.LocalDateTime;

public class DatabaseGisInterfaceStub implements DatabaseGisInterface {
  private LocationDataPoint locationDataPoint = new LocationDataPoint(0.0f, 0.0f, LocalDateTime.now());

  public void receiveStoreRequest(LocationDataPoint locationDataPoint) {
    this.locationDataPoint = locationDataPoint;
  }

  public LocationDataPoint getLocation() {
    return locationDataPoint;
  }

  public String receiveModeRequest(String mode) {
    return mode;
  }

  public String receiveNextSatRequest(String currentSat) {
    return currentSat;
  }

}