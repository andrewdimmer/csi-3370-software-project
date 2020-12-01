package edu.oakland.test.display01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import edu.oakland.production.display01.DisplayGpsManager;
import edu.oakland.production.display01.DisplayGpsManagerImplementation;
import edu.oakland.production.middleware01.MiddlewareGisInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display GPS Manager Unit Tests")
public class DisplayGpsManagerImplementationTests {
  
  @Test    
  @DisplayName("Indication that GPS signal strengths are received.")
  void receivedGpsSignalStrengths() {
    Satellite sat = new Satellite("word", 3);
    DisplayGpsManager man = new DisplayGpsManagerImplementation(
        new MiddlewareGisInterfaceStub()
    );
    assertEquals("word", man.receiveGpsSignalStrength(sat));
  }

  @Test
  @DisplayName("Indication that GPS signal strengths are received.")
  void recheckGpsSignalStrength() {
    Satellite sat = new Satellite("word", 3);
    DisplayGpsManager man = new DisplayGpsManagerImplementation(
        new MiddlewareGisInterfaceStub()
    );
    SatelliteSignalCheckRequest check = man.passGpsSignalStrength(sat);
    assertEquals("word", check.getSatelliteName());
    assertEquals("recheck", check.getCheckType());
  }

  @Test
  @DisplayName("Indication that GPS signal strengths are received.")
  void checkGpsSignalStrength() {
    Satellite sat = new Satellite("word", 3);
    DisplayGpsManager man = new DisplayGpsManagerImplementation(
        new MiddlewareGisInterfaceStub("test")
    );

    SatelliteSignalCheckRequest check = man.passGpsSignalStrength(sat);
    assertEquals("test", check.getSatelliteName());
    assertEquals("check", check.getCheckType());
  }
  
  @Test
  @DisplayName("Check if middleware GIS is not null")
  public void middlewareGisIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayGpsManagerImplementation(null);
    });
  }
}
