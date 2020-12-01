package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;

public interface DisplayGpsInterface {

  public boolean receiveGpsSignal(Satellite satelliteSignal);

  public String reportGpsSignalLoss(Satellite satelliteSignal);

  public int recheckSignalStrength(Satellite satelliteSignal);

  public int checkSignalStrength(Satellite satelliteSignal);

}
