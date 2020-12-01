package edu.oakland.test.display02;

import static org.junit.jupiter.api.Assertions.assertEquals;
<<<<<<< Updated upstream
import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display Comm 2 Way Interface Implementation Tests")
public class DisplayComm2WayInterfaceImplementationTests {

  @Test
  void rfidInIsRfidOut() {
    int rfid = 1101;  //rfid number?
    DisplayComm2WayInterfaceImplementation comm2Way = new DisplayComm2WayInterfaceImplementation();
    int out = comm2Way.rfid;
    assertEquals(rfid, out);
  }

  @Test
  void displayComm2WayIsNotNull() {
    DisplayCommManager manager = new DisplayCommManager();
    assertNotNull(manager, "Checking if class is null");
  }

=======
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayCommManager;
import edu.oakland.production.display02.DisplayCommManagerImplementation;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayComm2WayInterfaceImplementation;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DisplayComm2WayInterfaceImplementation Unit Tests")

public class DisplayComm2WayInterfaceImplementationTests {

  @Test 
  @DisplayName("CommManager is not null")
  void commManagerIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayComm2WayInterfaceImplementation(null);
    });
  }
>>>>>>> Stashed changes
}
