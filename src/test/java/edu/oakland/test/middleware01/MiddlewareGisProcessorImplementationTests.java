package edu.oakland.test.middleware01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;
import edu.oakland.production.middleware01.MiddlewareGisProcessorImplementation;
import edu.oakland.test.middleware01.MiddlewareGisManagerStub;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MiddlewareGisProcessorImplementation Unit Tests")
public class MiddlewareGisProcessorImplementationTests {

  @Test
  @DisplayName("Check if Signal Strength is null or not")
  void isGpsSignalStrengthNull() {
    Satellite satellite = new Satellite("GPS0", 5);
    MiddlewareGisManager stub = new MiddlewareGisManagerStub();

    MiddlewareGisProcessor gisProcessor = new MiddlewareGisProcessorImplementation(stub);
    assertEquals(satellite.getSatelliteName(), gisProcessor.measureGpsSignalStrength(satellite));
  }

  @Test
  @DisplayName("Check values Gps Signal Strength")
  void checkValuesGpsSignalStrength() {
    Satellite satellite = new Satellite("GPS0", 5);
    MiddlewareGisManager stub = new MiddlewareGisManagerStub();

    MiddlewareGisProcessor gisProcessor = new MiddlewareGisProcessorImplementation(stub);
    assertEquals(satellite.getSatelliteName(), gisProcessor.evaluateGpsSignalStrength(satellite));
  }

  @Test
  @DisplayName("Check if manager is not null")
  void managerIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareGisProcessorImplementation(null);
    });
  }
}