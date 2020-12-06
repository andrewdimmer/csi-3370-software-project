package edu.oakland.test.display01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import edu.oakland.production.display01.DisplayGpsInterfaceImplementation;
import edu.oakland.production.display01.DisplayGpsReceiver;
import edu.oakland.test.display01.DisplayGpsReceiverStub;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("DisplayGpsInterfaceImplementation Unit Tests")
@Tag("UnitTests")
public class DisplayGpsInterfaceImplementationTests {
  @Test
  @DisplayName("Verifying That Receiver Cannot Be Null")
  void verifyReceiverCannotBeNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayGpsInterfaceImplementation(null);
    });
  }

  @Test
  @DisplayName("Verifying Signal In is Signal Out")
  void signalInIsSignalOut() {
    Satellite s = new Satellite("New Satellite", 7);
    DisplayGpsInterfaceImplementation d;
    d = new DisplayGpsInterfaceImplementation(new DisplayGpsReceiverStub());
    assertEquals("New Satellite", d.receiveGpsSignal(s));
  }

  @Test
  @DisplayName("Verifying Satellite Name in is Satellite Name Out")
  void satelliteInIsSatelliteOutReportLoss() {
    Satellite s = new Satellite("New Satellite", 7);
    DisplayGpsInterfaceImplementation d;
    d = new DisplayGpsInterfaceImplementation(new DisplayGpsReceiverStub());
    SatelliteSignalCheckRequest ssrc = new SatelliteSignalCheckRequest("New Satellite", "Type 2");
    assertEquals(ssrc.getSatelliteName(), d.reportGpsSignalLoss(s).getSatelliteName());
  }

  @Test
  @DisplayName("Checking Satellite Signal")
  void satelliteInIsSatelliteOutCheck() {
    Satellite s = new Satellite("New Satellite", 7);
    DisplayGpsInterfaceImplementation d;
    d = new DisplayGpsInterfaceImplementation(new DisplayGpsReceiverStub());
    SatelliteSignalCheckRequest ssrc = new SatelliteSignalCheckRequest("New Satellite", "Type 2");
    assertEquals(ssrc.getSatelliteName(), d.checkSignalStrength(s).getSatelliteName());
  }

  @Test
  @DisplayName("Rechecking Satellite Signal")
  void satelliteInIsSatelliteOutRecheck() {
    Satellite s = new Satellite("New Satellite", 7);
    DisplayGpsInterfaceImplementation d;
    d = new DisplayGpsInterfaceImplementation(new DisplayGpsReceiverStub());
    SatelliteSignalCheckRequest ssrc = new SatelliteSignalCheckRequest("New Satellite", "Type 2");
    assertEquals(ssrc.getSatelliteName(), d.recheckSignalStrength(s).getSatelliteName());
  }

}
