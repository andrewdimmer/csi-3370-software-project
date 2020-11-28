package edu.oakland.test.middleware01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisManager;

public class MiddlewareGisManagerStub implements MiddlewareGisManager {
    
  public String receiveGpsSignalStrength(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();
  }
    
  public void storeLocationDataPoint() {

  }
    
  public String attemptToRegainGpsLock(String satelliteName) {
    return "";
  }
    
  public String evaluateGpsSignalStrength(boolean signalValid) {
    return "";
  }

}