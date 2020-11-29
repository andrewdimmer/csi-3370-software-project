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
    Satellite satellite = new Satellite();
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();

    MiddlewareGisManager gisManager = new DatabaseGisInterfaceImplementation(stub);
    assertEquals(satellite.getSatelliteName(), gisManager.receiveGpsSignalStrength(satellite));
  }

  @Test
  @DisplayName("Determine mode")
  void isCorrectModeEntered() {
    Satellite satelliteSignal = new Satellite();
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();

    MiddlewareGisManager man = new DatabaseGisInterfaceImplementation(stub);
    assertEquals(man.evaluateGpsSignalStrength(true), stub.receiveModeRequest("normal"));
    assertEquals(man.evaluateGpsSignalStrength(false), stub.receiveModeRequest("degraded"));
    assertEquals(man.evaluateGpsSignalStrength(true), stub.receiveModeRequest("stand by"));
    /* String datapoint = stub.receiveNextSatRequest(satelliteSignal.getSatelliteName());
    if (datapoint.equals("")){
      databaseGisInterface.receiveModeRequest("stand by");
    } else {
      databaseGisInterface.receiveModeRequest("degraded");
    }  */
  }

  @Test
  @DisplayName("Select new GPS")
  void selectNewGps() {
    Satellite satellite = new Satellite();
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    String nextSat = stub.receiveNextSatRequest(satellite.getSatelliteName());
    MiddlewareGisManager gisManager = new DatabaseGisInterfaceImplementation(stub);
    assertEquals(satellite.getSatelliteName(), name);
  }

  @Test
  @DisplayName("Check if DatabaseGISInterface is not null")
  void databaseInterfaceIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DatabaseGisInterfaceImplementation(null);
    });
  }
}