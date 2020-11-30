package edu.oakland.test.display02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.oakland.production.display02.DisplayComm2WayInterfaceImplementation;
import edu.oakland.production.display02.DisplayCommInterfaceImplementation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DisplayCommInterface Implementation Tests")
public class DisplayCommInterfaceImplementationTest {

  @Test
  void rfidInIsRfidOut() {
    int rfid = generateRandomRfid();
    DisplayCommInterfaceImplementation displayComm = new DisplayCommInterfaceImplementation();
    displayComm.receiveRfidRequest(rfid);
    int output = displayComm.rfid;
    assertEquals(rfid, output);
  }

  @Test
  void displayComm2WayIsNotNull() {
    DisplayComm2WayInterfaceImplementation dc = new DisplayComm2WayInterfaceImplementation();
    assertNotNull(dc, "Verify that class is not null");
  }

  /** Generates random number to stand in for the rfid.*/
  private int generateRandomRfid() {
    return (int) Math.random();
  }
}
