package edu.oakland.test.display01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import edu.oakland.production.display01.DisplayGpsReceiver;
import edu.oakland.production.display01.DisplayGpsReceiverImplementation;
import edu.oakland.test.display01.DisplayGpsManagerStub;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



@DisplayName ("DisplayGpsReceiverImplementation Unit Tests")
@Tag("UnitTests")
public class DisplayGpsReceiverImplementationTests {
  @Test
  @DisplayName ("Display GPS Manager Is Not Null")
  public void displayGpsManagerIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayGpsReceiverImplementation(null);
    });
  }

  @Test
  @DisplayName ("Gps Signal Strength Signal Is Not Null")
  public void measureGpsSignalStrengthSatelliteSignalIsNotNull() {
    DisplayGpsReceiverImplementation d = new DisplayGpsReceiverImplementation(
        new DisplayGpsManagerStub()
    );
    assertThrows(IllegalArgumentException.class, () -> {
      d.measureGpsSignalStrength(null);
    });
  }

  @Test
  @DisplayName ("Satellite Signal Is Not Null")
  public void measureSignalSatelliteSignalIsNotNull() {
    DisplayGpsReceiverImplementation d = new DisplayGpsReceiverImplementation(
        new DisplayGpsManagerStub()
    );
    assertThrows(IllegalArgumentException.class, () -> {
      d.measureSignal(null);
    });
  }

  @Test
  @DisplayName ("Gps Signal Strength In Is Signal Strength Out ")
  public void measureGpsSignalStrengthSatelliteInIsSignalOut() {
    DisplayGpsReceiverImplementation d = new DisplayGpsReceiverImplementation(
        new DisplayGpsManagerStub()
    );
    Satellite s = new Satellite("New Satellite", 7);
    assertEquals(s.getSatelliteName(), d.measureGpsSignalStrength(s));
  }

  @Test
  @DisplayName ("Measure Signal In Is Signal Out")
  public void measureSignalSignalInIsSignalOut() {
    DisplayGpsReceiverImplementation d = new DisplayGpsReceiverImplementation(
        new DisplayGpsManagerStub()
    );
    Satellite s = new Satellite("New Satellite", 7);
    assertEquals(s.getSatelliteName(), d.measureSignal(s).getSatelliteName());
  }
}
