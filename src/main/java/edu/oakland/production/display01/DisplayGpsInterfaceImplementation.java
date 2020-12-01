package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import edu.oakland.production.display01.DisplayGpsReceiver;
import edu.oakland.test.display01.DisplayGpsReceiverStub;

public class DisplayGpsInterfaceImplementation implements DisplayGpsInterface {
  public DisplayGpsReceiverStub reciever;
  public DisplayGpsInterfaceImplementation(DisplayGpsReceiverStub reciever) {
    this.reciever = reciever;
  }
  public String receiveGpsSignal(Satellite satelliteSignal) {
    System.out.println("Recieved GPS Signal from:");
    String satellite = reciever.measureGpsSignalStrength(satelliteSignal);
    System.out.println(satellite);
    return satellite;
  }

  public String reportGpsSignalLoss(Satellite satelliteSignal) {
    System.out.println("Reporting loss for:");
    SatelliteSignalCheckRequest satellite = reciever.measureSignal(satelliteSignal);
    System.out.println(satellite.getSatelliteName());
    return satellite.getSatelliteName();
  }

  public String recheckSignalStrength(Satellite satelliteSignal) {
    System.out.println("Rechecking signal strength");
    SatelliteSignalCheckRequest satellite = reciever.measureSignal(satelliteSignal);
    System.out.println(satellite.getSatelliteName());
    return satellite.getSatelliteName();
  }

  public String checkSignalStrength(Satellite satelliteSignal) {
    System.out.println("Checking signal strength");
    SatelliteSignalCheckRequest satellite = reciever.measureSignal(satelliteSignal);
    System.out.println(satellite.getSatelliteName());
    return satellite.getSatelliteName();
  }

} 
