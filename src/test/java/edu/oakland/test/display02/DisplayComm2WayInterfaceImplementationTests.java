package edu.oakland.test.Display02;

import edu.oakland.production.display02.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display Comm 2 Way Interface Implementation Tests")
public class DisplayComm2WayInterfaceImplementationTests {
    @Test
    void rfidInIsRfidOut(){
        int rfid = 1101;//rfid number?
        DisplayComm2WayInterfaceImplementation comm2Way = new DisplayComm2WayInterfaceImplementation();
        int out = comm2Way.rfid;
        assertEquals(rfid, out);
        }
    @Test
    void displayComm2WayIsNotNull(){
        DisplayCommManager manager = new DisplayCommManager();
        assertNotNull(manager, "Checking if class is null");
    }
}