package edu.oakland.test.middleware01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.database.DatabaseGisInterface;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware01.MiddlewareGisManagerImplementation;
import edu.oakland.test.middleware01.DatabaseGisInterfaceStub;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MiddlewareGisManagerImplementation Unit Tests")
public class MiddlewareGisManagerImplementationTests {

  @Test
  @DisplayName("Check if the data point is not null")
  void nullLocationDataPointNotStored() {
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager manager = new MiddlewareGisManagerImplementation(stub);
    Satellite satellite = new Satellite("GPS0", 1);
    manager.receiveGpsSignalStrength(satellite);
    manager.storeLocationDataPoint();
    assertNotNull(stub.getLocation());
  }

  @Test
  @DisplayName("Evaluate Signal Strength True")
  void isGpsSignalStrengthEvaluatedTrue() {
    Satellite.satelliteInit(0, 0, new LocationDataPoint(0, 0, LocalDateTime.now()));
    Satellite satellite = new Satellite("GPS0", 5);
    DatabaseGisInterface stub = new DatabaseGisInterfaceStub();

    MiddlewareGisManager gisManager = new MiddlewareGisManagerImplementation(stub);
    assertTrue(gisManager.receiveGpsSignalStrength(satellite).contains("was strong enough"));
  }

  @Test
  @DisplayName("Evaluate Signal Strength False")
  void isGpsSignalStrengthEvaluatedFalse() {
    Satellite.satelliteInit(0, 0, new LocationDataPoint(0, 0, LocalDateTime.now()));
    Satellite satellite = new Satellite("GPS0", 1);
    DatabaseGisInterface stub = new DatabaseGisInterfaceStub();

    MiddlewareGisManager gisManager = new MiddlewareGisManagerImplementation(stub);
    assertTrue(gisManager.receiveGpsSignalStrength(satellite).contains("was not strong enough"));
  }

  @Test
  @DisplayName("Check if the LocationDataPoint in is LDP out")
  void ldpInIsLdpOut() {
    LocationDataPoint ldp = new LocationDataPoint(0, 0, LocalDateTime.now());
    Satellite.satelliteInit(0, 0, ldp);
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager manager = new MiddlewareGisManagerImplementation(stub);
    Satellite satellite = new Satellite("GPS0", 5);
    manager.receiveGpsSignalStrength(satellite);
    manager.storeLocationDataPoint();
    assertEquals(ldp.getLat(), stub.getLocation().getLat(), .001);
    assertEquals(ldp.getLng(), stub.getLocation().getLng(), .001);
    assertEquals(ldp.getTime(), stub.getLocation().getTime());
  }

  @Test
  @DisplayName("Enter degraded from normal")
  void enterDegradedFromNormal() {
    Satellite satSignal = new Satellite("GPS0", 1);
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager man = new MiddlewareGisManagerImplementation(stub);
    String stubName = man.evaluateGpsSignalStrength(satSignal);
    Satellite stubSignal = new Satellite(stubName, 1);
    assertEquals(satSignal.getSatelliteName(), man.evaluateGpsSignalStrength(stubSignal));
    assertEquals("degraded", stub.getMode());
  }

  @Test
  @DisplayName("Enter normal from degraded")
  void enterNormalFromDegraded() {
    Satellite satSignal = new Satellite("GPS0", 1);
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager man = new MiddlewareGisManagerImplementation(stub);
    String stubName = man.evaluateGpsSignalStrength(satSignal);
    Satellite stubSignal = new Satellite(stubName, 1);
    String newName = man.evaluateGpsSignalStrength(stubSignal);
    Satellite newSignal = new Satellite(newName, 5);
    assertEquals("N/A. Reconnected.", man.evaluateGpsSignalStrength(newSignal));
    assertEquals("normal", stub.getMode());
  }

  @Test
  @DisplayName("Enter standby from normal")
  void enterStandbyFromNormal() {
    Satellite satSignal = new Satellite("GPS1", 1);
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager man = new MiddlewareGisManagerImplementation(stub);
    String stubName = man.evaluateGpsSignalStrength(satSignal);
    stubName = "";
    Satellite stubSignal = new Satellite(stubName, 1);
    assertEquals("", man.evaluateGpsSignalStrength(stubSignal));
    assertEquals("standby", stub.getMode());
  }

  @Test
  @DisplayName("Enter degraded from standby")
  void enterDegradedFromStandby() {
    Satellite satSignal = new Satellite("GPS1", 1);
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager man = new MiddlewareGisManagerImplementation(stub);
    String stubName = man.evaluateGpsSignalStrength(satSignal);
    stubName = "";
    Satellite stubSignal = new Satellite(stubName, 1);
    String newName = man.evaluateGpsSignalStrength(stubSignal);
    Satellite newSignal = new Satellite(newName, 5);
    assertEquals("N/A. Reconnected.", man.evaluateGpsSignalStrength(newSignal));
    assertEquals("degraded", stub.getMode());
  }

  @Test
  @DisplayName("Enter normal from degraded False")
  void enterNormalFromDegradedFalse() {
    Satellite satSignal = new Satellite("GPS0", 1);
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager man = new MiddlewareGisManagerImplementation(stub);
    String stubName = man.evaluateGpsSignalStrength(satSignal);
    Satellite stubSignal = new Satellite(stubName, 1);
    String newName = man.evaluateGpsSignalStrength(stubSignal);
    newName = "";
    Satellite newSignal = new Satellite(newName, 5);
    assertEquals("N/A. Reconnected.", man.evaluateGpsSignalStrength(newSignal));
    assertEquals("degraded", stub.getMode());
  }

  @Test
  @DisplayName("Enter standby from standby")
  void enterStandbyFromStandby() {
    Satellite satSignal = new Satellite("GPS1", 1);
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager man = new MiddlewareGisManagerImplementation(stub);
    String stubName = man.evaluateGpsSignalStrength(satSignal);
    stubName = "";
    Satellite stubSignal = new Satellite(stubName, 1);
    man.evaluateGpsSignalStrength(stubSignal);
    satSignal = new Satellite("GPS1", 1);
    assertEquals("GPS1", man.evaluateGpsSignalStrength(satSignal));
    assertEquals("standby", stub.getMode());
  }

  @Test
  @DisplayName("Enter standby from standby via Empty Next")
  void enterStandbyFromStandbyViaEmptyNext() {
    Satellite satSignal = new Satellite("GPS1", 1);
    DatabaseGisInterfaceStub stub = new DatabaseGisInterfaceStub();
    MiddlewareGisManager man = new MiddlewareGisManagerImplementation(stub);
    String stubName = man.evaluateGpsSignalStrength(satSignal);
    stubName = "";
    Satellite stubSignal = new Satellite(stubName, 1);
    man.evaluateGpsSignalStrength(stubSignal);
    satSignal = new Satellite("", 1);
    assertEquals("", man.evaluateGpsSignalStrength(satSignal));
    assertEquals("standby", stub.getMode());
  }

  @Test
  @DisplayName("Check if DatabaseGISInterface is not null")
  void databaseInterfaceIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareGisManagerImplementation(null);
    });
  }
}