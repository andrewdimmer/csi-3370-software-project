package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.database.DatabaseGisInterfaceImplementation;
import edu.oakland.test.database.DatabaseGisManagerStub;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DatabaseGisInterfaceImplementation Unit Tests")
public class DatabaseGisInterfaceTest {

  @Test
  @DisplayName("LDP going in the same LDP coming out")
  void dataPointInIsDataPointOut() {
    DatabaseGisManagerStub dgms = new DatabaseGisManagerStub();
    DatabaseGisInterfaceImplementation dgi = new DatabaseGisInterfaceImplementation(dgms);
    LocationDataPoint ldp = new LocationDataPoint(0, 0, LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
    ));
    dgi.receiveStoreRequest(ldp);
    assertEquals(ldp, dgms.getLocationDataPoint());
  }

  @Test
  @DisplayName("Putting in the current satellite returns the new satellite")
  void currentSatGetsNextSat() {
    DatabaseGisManagerStub dgms = new DatabaseGisManagerStub();
    DatabaseGisInterfaceImplementation dgi = new DatabaseGisInterfaceImplementation(dgms);
    String currentSat = "";
    assertEquals(currentSat, dgi.receiveNextSatRequest(currentSat));
  }

  @Test
  @DisplayName("The Mode Requested is the Actual Mode")
  void modeInIsModeOut() {
    DatabaseGisManagerStub dgms = new DatabaseGisManagerStub();
    DatabaseGisInterfaceImplementation dgi = new DatabaseGisInterfaceImplementation(dgms);
    String n = "normal";
    dgi.receiveModeRequest(n);
    assertEquals(n, dgms.getMode()); //supposed to return a String with the mode
  }
   
  @Test
  @DisplayName("Checks that manager isn't null")
  void databaseGisManagerNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DatabaseGisInterfaceImplementation(null);
    });
  }

}
