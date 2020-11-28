package edu.oakland.test.middleware01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.test.middleware01.MiddlewareGisManagerStub;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;
import edu.oakland.production.middleware01.MiddlewareGisProcessorImplementation;

import edu.oakland.helper.admin.Satellite;
import java.lang.IllegalArgumentException;
import edu.oakland.helper.admin.LocationDataPoint;

@DisplayName("Middleware GIS processor test")
public class MiddlewareGisProcessorImplementationTests {
  @Test
  @DisplayName("Check if Signal Strength is null or not")
  void isGpsSignalStrengthNull(){
    Satellite satellite = new Satellite();

    MiddlewareGisProcessor gisProcessor = new MiddlewareGisProcessorImplementation(new MiddlewareGisManagerStub());
    assertEquals(satellite.getSatelliteName(), gisProcessor.measureGpsSignalStrength(satellite));

  }
  @Test
  @DisplayName("Check values Gps Signal Strength")
  void checkValuesGpsSignalStrength(){
    Satellite satellite = new Satellite();

    MiddlewareGisProcessor gisProcessor = new MiddlewareGisProcessorImplementation(new MiddlewareGisManagerStub());
    assertEquals(satellite.getSatelliteName(), gisProcessor.evaluateGpsSignalStrength(satellite));

  }
  @Test
  @DisplayName("Check if manager is not null")
  void managerIsNotNull(){
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareGisProcessorImplementation(null);
    });
  }
}