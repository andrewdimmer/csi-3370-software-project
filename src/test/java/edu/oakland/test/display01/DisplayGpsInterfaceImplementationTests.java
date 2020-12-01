package edu.oakland.test.display01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsInterfaceImplementation;
import edu.oakland.production.display01.DisplayGpsReceiver;
import edu.oakland.test.display01.DisplayGpsReceiverStub;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Display GPS Interface Unit Tests")
public class DisplayGpsInterfaceImplementationTests {
  @Test
  @DisplayName("Verifying Signal In is Signal Out")
  void signalInIsSignalOut() {
    Satellite s = new Satellite("New Satellite", 7);
    DisplayGpsInterfaceImplementation d;
    d = new DisplayGpsInterfaceImplementation(new DisplayGpsReceiverStub());
    assertEquals(d.receiveGpsSignal(s), "New Satellite");
  }

  @Test
  @DisplayName("Verifying Satellite Name in is Satellite Name Out")
  void satelliteInIsSatelliteOutReportLoss() {
    Satellite s = new Satellite("New Satellite", 7);
    DisplayGpsInterfaceImplementation d;
    d = new DisplayGpsInterfaceImplementation(new DisplayGpsReceiverStub());
    assertEquals(d.reportGpsSignalLoss(s), "New Satellite");
  }

  @Test
  @DisplayName("Checking Satellite Signal")
  void satelliteInIsSatelliteOutCheck() {
    Satellite s = new Satellite("New Satellite", 7);
    DisplayGpsInterfaceImplementation d;
    d = new DisplayGpsInterfaceImplementation(new DisplayGpsReceiverStub());
    assertEquals(d.checkSignalStrength(s), "New Satellite");
  }

  @Test
  @DisplayName("Rechecking Satellite Signal")
  void satelliteInIsSatelliteOutRecheck() {
    Satellite s = new Satellite("New Satellite", 7);
    DisplayGpsInterfaceImplementation d;
    d = new DisplayGpsInterfaceImplementation(new DisplayGpsReceiverStub());
    assertEquals(d.recheckSignalStrength(s), "New Satellite");
  }

}
