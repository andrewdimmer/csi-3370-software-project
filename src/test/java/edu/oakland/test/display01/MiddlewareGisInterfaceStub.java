package edu.oakland.test.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisInterface;

public class MiddlewareGisInterfaceStub implements MiddlewareGisInterface {

  public String receiveGpsSignalStrengths(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();
  }

  public String receiveGpsSignalStrengths(String satelliteName) {
    return satelliteSignal.getSatelliteName();
  }
}

