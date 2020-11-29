package edu.oakland.test.middleware01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisInterface;
import edu.oakland.production.middleware01.MiddlewareGisInterfaceImplementation;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;
import edu.oakland.test.middleware01.MiddlewareGisProcessorStub;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MiddlewareGisInterfaceImplementation Unit Tests")
public class MiddlewareGisInterfaceImplementationTests {

  @Test
  @DisplayName("Signal pass successful from interface to Display")
  void passSignalStrengthUc1() {
    Satellite sat = new Satellite("GPS0", 5);
    MiddlewareGisProcessor stub = new MiddlewareGisProcessorStub();
    MiddlewareGisInterface gisInterface = new MiddlewareGisInterfaceImplementation(stub);
    assertEquals(sat.getSatelliteName(), gisInterface.receiveGpsSignalStrengthUc1(sat));
  }

  @Test
  @DisplayName("Signal pass successful from interface to Display")
  void passSignalStrengthUc2() {
    Satellite sat = new Satellite("GPS0", 5);
    MiddlewareGisProcessor stub = new MiddlewareGisProcessorStub();
    MiddlewareGisInterface gisInterface = new MiddlewareGisInterfaceImplementation(stub);
    assertEquals(sat.getSatelliteName(), gisInterface.receiveGpsSignalStrengthUc2(sat));    
  }

  @Test
  @DisplayName("MiddlewareGisProcessor is not null")
  void processorIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareGisInterfaceImplementation(null);
    });
  }
}
