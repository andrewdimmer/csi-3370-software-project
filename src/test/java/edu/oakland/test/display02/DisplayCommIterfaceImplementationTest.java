package edu.oakland.test.Display02;

import edu.oakland.production.display02.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display Comm Interface Implementation Tests")
public class DisplayCommInterfaceImplementationTest
{

    @Test

    void rfidInIsRfidOut()
    {
        int rfid = generateRandomRfid();
        DisplayCommInterfaceImplementation displayComm = new DisplayCommInterfaceImplementation();
        displayComm.receiveRfidRequest(rfid);
        int output = displayComm.rfid;
        assertEquals(rfid, output);
      }

    @Test
    void displayComm2WayIsNotNull()
    {
        DisplayComm2WayInterfaceImplementation DC = new DisplayComm2WayInterfaceImplementation();
        assertNotNull(DC, "Verify that class is not null");
    }
    private int generateRandomRfid() {
        return (int) Math.random();
      }
}
