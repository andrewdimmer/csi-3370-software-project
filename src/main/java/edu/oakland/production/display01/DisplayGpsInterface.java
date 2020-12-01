package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public interface DisplayGpsInterface {

  public String receiveGpsSignal(Satellite satelliteSignal);

  public SatelliteSignalCheckRequest reportGpsSignalLoss(Satellite satelliteSignal);

  public SatelliteSignalCheckRequest recheckSignalStrength(Satellite satelliteSignal);

  public SatelliteSignalCheckRequest checkSignalStrength(Satellite satelliteSignal);

}
