package edu.oakland.test.middleware01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.database.DatabaseGisInterface;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware01.MiddlewareGisManagerImplementation;
import edu.oakland.test.middleware01.DatabaseGisInterfaceStub;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MiddlewareGisManagerImplementation Unit Tests")
public class MiddlewareGisManagerImplementationTests {

  @Test
  @DisplayName("Check if the data point is null")
  void nullLocationDataPointNotStored() {
    
  }

  @Test
  @DisplayName("Check if lock is regained")
  void isGpsLockRegained() {

  }

  @Test
  @DisplayName("Evaluate Signal Strength")
  void isGpsSignalStrengthEvaluated() {
    Satellite satellite = new Satellite("GPS0", 5);
    DatabaseGisInterface stub = new DatabaseGisInterfaceStub();

    MiddlewareGisManager gisManager = new MiddlewareGisManagerImplementation(stub);
    assertEquals(satellite.getSatelliteName(), gisManager.receiveGpsSignalStrength(satellite));
  }

  @Test
  @DisplayName("Determine mode")
  void isCorrectModeEntered() {
    Satellite satelliteSignal = new Satellite("GPS0", 5);
    Satellite satelliteSignal2 = new Satellite("", 5);
    DatabaseGisInterface stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager man = new MiddlewareGisManagerImplementation(stub);
    String name = satelliteSignal.getSatelliteName();
    String name2 = satelliteSignal2.getSatelliteName();

    String datapoint = stub.receiveNextSatRequest(name);
    String datapoint2 = stub.receiveNextSatRequest(name2);

    assertEquals(man.evaluateGpsSignalStrength(true), stub.receiveModeRequest("normal"));
    if (datapoint.equals("")) {
      assertEquals(man.evaluateGpsSignalStrength(false), stub.receiveModeRequest("stand by"));
    } else if (datapoint2.equals("GPS0")) {
      assertEquals(man.evaluateGpsSignalStrength(false), stub.receiveModeRequest("degraded"));
    }
  }

  @Test
  @DisplayName("Select new GPS")
  void selectNewGps() {
    Satellite satellite = new Satellite("GPS0", 5);
    DatabaseGisInterface stub = new DatabaseGisInterfaceStub();
    String nextSat = stub.receiveNextSatRequest(satellite.getSatelliteName());
    MiddlewareGisManager gisManager = new MiddlewareGisManagerImplementation(stub);
    assertEquals(satellite.getSatelliteName(), nextSat);
  }

  @Test
  @DisplayName("Check if DatabaseGISInterface is not null")
  void databaseInterfaceIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareGisManagerImplementation(null);
    });
  }
}