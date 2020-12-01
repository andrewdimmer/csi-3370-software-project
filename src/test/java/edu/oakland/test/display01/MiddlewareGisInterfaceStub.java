package edu.oakland.test.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisInterface;

public class MiddlewareGisInterfaceStub implements MiddlewareGisInterface {

  public String receiveGpsSignalStrengthsUc1(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();
  }

  public String receiveGpsSignalStrengthsUc2(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();
  }
}

