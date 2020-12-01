package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import edu.oakland.production.display01.DisplayGpsReceiver;

public class DisplayGpsInterfaceImplementation implements DisplayGpsInterface {
  
  public DisplayGpsReceiver reciever;

  public DisplayGpsInterfaceImplementation(DisplayGpsReceiver reciever) {
    this.reciever = reciever;
  }

  /** 
   * Recieves GPS Signal Strength.
   *
   * @param satelliteSignal GPS signal to measure.
   * @return Which GPS Recived 
   */
  public String receiveGpsSignal(Satellite satelliteSignal) {
    System.out.println("Recieved GPS Signal from:");
    String satellite = reciever.measureGpsSignalStrength(satelliteSignal);
    System.out.println(satellite);
    return satellite;
  }

  /** 
   * Reports GPS Signal Loss.
   *
   * @param satelliteSignal GPS signal to report.
   * @return Which GPS has Loss of Signal 
   */
  public SatelliteSignalCheckRequest reportGpsSignalLoss(Satellite satelliteSignal) {
    System.out.println("Reporting loss for:");
    SatelliteSignalCheckRequest satellite = reciever.measureSignal(satelliteSignal);
    System.out.println("Attempting to " + satellite.getCheckType() + " " + satellite.getSatelliteName());
    return satellite;
  }

  /** 
   * Rechecks GPS Signal Strength.
   *
   * @param satelliteSignal GPS signal to measure.
   * @return Which GPS Rechecked 
   */
  public SatelliteSignalCheckRequest recheckSignalStrength(Satellite satelliteSignal) {
    System.out.println("Rechecking signal strength");
    SatelliteSignalCheckRequest satellite = reciever.measureSignal(satelliteSignal);
    System.out.println(satellite.getSatelliteName());
    return satellite;
  }

  /** 
   * Checks GPS Signal Strength.
   *
   * @param satelliteSignal GPS signal to measure.
   * @return Which GPS Checked 
   */
  public SatelliteSignalCheckRequest checkSignalStrength(Satellite satelliteSignal) {
    System.out.println("Checking signal strength");
    SatelliteSignalCheckRequest satellite = reciever.measureSignal(satelliteSignal);
    System.out.println(satellite.getSatelliteName());
    return satellite;
  }

} 
