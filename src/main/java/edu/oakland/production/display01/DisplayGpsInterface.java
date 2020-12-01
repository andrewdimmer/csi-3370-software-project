package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;

public interface DisplayGpsInterface {

  public String receiveGpsSignal(Satellite satelliteSignal);

  public String reportGpsSignalLoss(Satellite satelliteSignal);

  public String recheckSignalStrength(Satellite satelliteSignal);

  public String checkSignalStrength(Satellite satelliteSignal);

}
