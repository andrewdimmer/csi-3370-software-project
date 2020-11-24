package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;

public interface DisplayGpsInterface {

  public void recieveGpsSignals(Satellite satelliteSignal);

  public void reportGpsSignalLoss(String satelliteName);

  public void recheckSignalStrength(String satelliteName);

  public void checkSignalStrength(String satelliteName);

}
