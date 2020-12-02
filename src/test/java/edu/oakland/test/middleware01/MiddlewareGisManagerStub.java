package edu.oakland.test.middleware01;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisManager;


public class MiddlewareGisManagerStub implements MiddlewareGisManager {
    
  public LocationDataPoint locationDataPoint1;
  public LocationDataPoint locationDataPoint2;

  public MiddlewareGisManagerStub(LocationDataPoint locationDataPoint1) {
    this.locationDataPoint1 = locationDataPoint1;
  }

  public LocationDataPoint getLocation2() {
    return locationDataPoint2;
  }
  public String receiveGpsSignalStrength(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();
  }
    
  public void storeLocationDataPoint() {
    locationDataPoint2 = locationDataPoint1;
  }
    
  public String attemptToRegainGpsLock(String satelliteName) {
    return "";
  }
    
  public String evaluateGpsSignalStrength(Satellite satellite) {
    return satellite.getSatelliteName();
  }

}
