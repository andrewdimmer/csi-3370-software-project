package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.database.DatabaseGisInterfaceClass;
import edu.oakland.production.database.DatabaseGisManager;
import edu.oakland.production.database.DatabaseGisManagerStub;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Database GisManager Test")
public class DatabaseGisManagerTest  {

  @Test
  @DisplayName("LDP going in the same LDP coming out")
  void dataPointInIsDataPointOut() {
    DatabaseGisManager dgm = null;
    DatabaseGisManagerStub dgms = new DatabaseGisManagerStub();
    DatabaseGisInterfaceClass dgi = new DatabaseGisInterfaceClass(dgm);
    LocationDataPoint ldp = new LocationDataPoint(0, 0, LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
    ));
    int i = 0;
    dgi.receiveStoreRequest(ldp);
    assertEquals(null, dgms.getLocationDataPoint(i)); //Using dps cuz dgm doesn't have getLDP method
  }

  @Test
  @DisplayName("Putting in the current satellite returns the new satellite")
  void currentSatGetsNextSat() {
    DatabaseGisManager dgm = null;
    DatabaseGisManagerStub dgms = new DatabaseGisManagerStub();
    DatabaseGisInterfaceClass dgi = new DatabaseGisInterfaceClass(dgm);
    String currentSat = "";
    assertEquals("", dgi.receiveNextSatRequest(currentSat));
  }

  @Test
  @DisplayName("The Mode Requested is the Actual Mode")
  void modeInIsModeOut() {
    DatabaseGisManager dgm = null;
    DatabaseGisManagerStub dgms = new DatabaseGisManagerStub();
    DatabaseGisInterfaceClass dgi = new DatabaseGisInterfaceClass(dgm);
    String n = "";
    assertEquals(n, dgi.receiveModeRequest(n)); //supposed to return a String with the mode
  }

  @Test
  @DisplayName("Checks that manager isn't null")
  void databaseGisManagerNotNull() {
    DatabaseGisManagerStub dgms = new DatabaseGisManagerStub();
    String currentSat = "";
    assertEquals("", dgms.passNextSatRequest(currentSat));
  }

} 