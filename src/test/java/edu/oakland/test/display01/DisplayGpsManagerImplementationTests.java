package edu.oakland.test.display01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.display01.DisplayGpsManagerImplementation;
import edu.oakland.middleware01.MiddlewareGisInterface;
import edu.oakland.production.middleware01.MiddlewareGisInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.oakland.helper.admin.Satellite;

@DisplayName("Display GPS Manager Unit Tests")
public class DisplayGpsManagerImplementationTests {
  String satellite = receivedGpsSignalStrengthsUC1(receivedGpsSignalStrengths);
      
  @DisplayName("Indication that GPS signal strengths are received.")
  void receivedGpsSignalStrengths() {
    Satellite sat = new Satellite();
    DisplayGpsManagerImplementation man = new DisplayGpsInterfaceImplementation();
    AssertEquals(satelliteSignal.receivedGpsSignalStrengths(sat));
  }

  @Test
  @DisplayName("Check if middleware GIS is not null")
  public void middlewareGisIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayGpsManagerImplementation(null);
    });
  }
}