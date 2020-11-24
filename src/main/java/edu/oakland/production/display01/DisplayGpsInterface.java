package main.java.edu.oakland.production;

import edu.oakland.helper.admin.Satellite;

public interface DisplayGpsInterface {

  public void recieveGpsSingnals(Satellite satelliteSignal);

  public void reportGpsSignalLoss(String satelliteName);

  public void recheckSignalStrength(String satelliteName);

  public void checkSignalStrength(String satelliteName);

}