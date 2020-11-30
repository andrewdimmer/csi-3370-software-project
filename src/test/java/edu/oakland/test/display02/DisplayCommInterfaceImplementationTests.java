package edu.oakland.test.display02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommInterface;
import edu.oakland.production.display02.DisplayCommInterfaceImplementation;
import edu.oakland.test.display02.DisplayComm2WayInterfaceStub;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DisplayCommInterfaceImplementation Tests")

public class DisplayCommInterfaceImplementationTests {

  @Test
  @DisplayName("RFID In Is the same as Rfid Out")
  void rfidInIsRfidOut() {
    int rfid = generateRandomRfid();
    DisplayComm2WayInterfaceStub testStub = new DisplayComm2WayInterfaceStub();
    DisplayCommInterfaceImplementation displayComm = 
      new DisplayCommInterfaceImplementation(testStub);
    assertEquals(rfid, Integer.parseInt(displayComm.receiveRfidRequest(rfid).getStatusMessage()));

  }
  
  private int generateRandomRfid() {
    return (int) Math.random();
  }

  @Test 
  @DisplayName("DisplayComm2Way is not null")
  void display2WayIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayCommInterfaceImplementation(null);
    });
  }
}
