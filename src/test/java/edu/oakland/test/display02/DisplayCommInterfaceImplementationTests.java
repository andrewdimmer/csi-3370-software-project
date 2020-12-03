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
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DisplayCommInterfaceImplementation Tests")

public class DisplayCommInterfaceImplementationTests {

  @Test
  @DisplayName("RFID In Is the same as Rfid Out")
  void rfidInIsRfidOut() {
    int rfid = generateRandomRfid();
    DisplayComm2WayInterfaceStub testStub = new DisplayComm2WayInterfaceStub(
        new TrackData(
            generateRandomLocationDataPointsArray(5),
            generateRandomCourse(),
            generateRandomSpeed()
        )
    );
    DisplayCommInterfaceImplementation displayComm = 
        new DisplayCommInterfaceImplementation(testStub);
    assertEquals(rfid, Integer.parseInt(displayComm.receiveRfidRequest(rfid).getStatusMessage()));
  }

  @Test
  @DisplayName("0 Point TrackData does not display plot")
  void zeroPointTrackDataDoesNotDisplayPlot() {
    int rfid = generateRandomRfid();
    DisplayComm2WayInterfaceStub testStub = new DisplayComm2WayInterfaceStub(
        new TrackData(new LocationDataPoint[0])
    );
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

  //Methods borrowed from our lovely admin
  private float generateRandomCourse() {
    return (float) (Math.random() * 360);
  }

  private float generateRandomSpeed() {
    return (float) (Math.random() * 30);
  }

  private LocationDataPoint[] generateRandomLocationDataPointsArray(int length) {
    LocationDataPoint[] locations = new LocationDataPoint[length];
    for (int index = 0; index < locations.length; index++) {
      locations[index] = generateRandomLocationDataPoint();
    }
    return locations;
  }

  private LocationDataPoint generateRandomLocationDataPoint() {
    return new LocationDataPoint(
      (float) (Math.random() * 180 - 90),
      (float) (Math.random() * 360 - 180),
      LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
      )
    );
  }
}
