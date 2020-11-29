package edu.oakland.test.middleware01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.oakland.production.middleware01.MiddlewareGisProcessor;
import edu.oakland.test.middleware01.MiddlewareGisProcessorStub;
import edu.oakland.production.middleware01.MiddlewareGisInterface;
import edu.oakland.production.middleware01.MiddlewareGisInterfaceImplementation;

import edu.oakland.helper.admin.Satellite;
import java.lang.IllegalArgumentException;
import edu.oakland.helper.admin.LocationDataPoint;

@DisplayName("MiddlewareGisInterfaceImplementation Unit Tests")
public class MiddlewareGisInterfaceImplementationTests {

  @Test
  @DisplayName("Signal pass successful from interface to Display")
  void passSignalStrengthUc1() {
    Satellite satellite = new Satellite();

    MiddlewareGisInterface gisInterface = new MiddlewareGisInterfaceImplementation(new MiddlewareGisProcessorStub());
    assertEquals(satellite.getSatelliteName(), gisInterface.receiveGpsSignalStrengthUc1(satellite));
  }

  @Test
  @DisplayName("Signal pass successful from interface to Display")
  void passSignalStrengthUc2() {
    Satellite satellite = new Satellite();

    MiddlewareGisInterface gisInterface = new MiddlewareGisInterfaceImplementation(new MiddlewareGisProcessorStub());
    assertEquals(satellite.getSatelliteName(), gisInterface.receiveGpsSignalStrengthUc2(satellite));    
  }

  @Test
  @DisplayName("MiddlewareGisProcessor is not null")
  void processorIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareGisInterfaceImplementation(null);
    });
  }
}
