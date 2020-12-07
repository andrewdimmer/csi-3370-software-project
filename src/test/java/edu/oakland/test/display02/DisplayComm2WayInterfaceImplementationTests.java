package edu.oakland.test.display02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.display02.DisplayComm2WayInterfaceImplementation;
import edu.oakland.test.display02.DisplayCommManagerStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DisplayComm2WayInterfaceImplementation Unit Tests")

public class DisplayComm2WayInterfaceImplementationTests {
  @Test
  @DisplayName("RFID In Is the same as Rfid Out")
  void rfidInIsRfidOut() {
    int rfid = generateRandomRfid();
    DisplayCommManagerStub testStub = new DisplayCommManagerStub();
    DisplayComm2WayInterfaceImplementation comm2Way = 
        new DisplayComm2WayInterfaceImplementation(testStub);
    assertEquals(rfid, Integer.parseInt(comm2Way.passRfidRequest(rfid).getStatusMessage()));

  }

  private int generateRandomRfid() {
    return (int) Math.random();
  }

  @Test 
  @DisplayName("CommManager is not null")
  void commManagerIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayComm2WayInterfaceImplementation(null);
    });
  }
}
