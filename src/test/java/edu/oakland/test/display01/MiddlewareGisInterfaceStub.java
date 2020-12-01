package edu.oakland.test.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisInterface;

public class MiddlewareGisInterfaceStub implements MiddlewareGisInterface {

  private String satelliteName; 

  public MiddlewareGisInterfaceStub() {
  
  }

  public MiddlewareGisInterfaceStub(String satelliteName) {
    this.satelliteName = satelliteName; 
  }

  public String receiveGpsSignalStrengthUc1(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();
  }

  public String receiveGpsSignalStrengthUc2(Satellite satelliteSignal) {
    return satelliteName == null ? satelliteSignal.getSatelliteName() : satelliteName;
  }
}

