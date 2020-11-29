package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;

public class DisplayGpsInterfaceImplementation implements DisplayGpsInterface {

  public boolean receiveGpsSignal(Satellite satelliteSignal) {
    return true;
  }

  public String reportGpsSignalLoss(Satellite satelliteSignal) {
    return "";
  }

  public int recheckSignalStrength(Satellite satelliteSignal) {
    return 0;
  }

  public int checkSignalStrength(Satellite satelliteSignal) {
    return 0;
  }

} 
