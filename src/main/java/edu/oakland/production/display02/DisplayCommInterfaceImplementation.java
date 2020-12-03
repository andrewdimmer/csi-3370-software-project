package edu.oakland.production.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.display02.TrackDataPlotter;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommInterface;
import java.lang.IllegalArgumentException;

/**
* This class receives the rfid, evaluates it,
* then passes it along to Comm2Way.
*
*/
public class DisplayCommInterfaceImplementation implements DisplayCommInterface {

  private DisplayComm2WayInterface comm2Way;

  /**
  * Creates a DisplayCommInterfaceImplementation to receive the rfid.
  * param DisplatComm2WayInterface: The class that DisplayCommInterface will pass the rfid to.
  *
  */
  public DisplayCommInterfaceImplementation(DisplayComm2WayInterface displayComm2WayInterface) {
    if (displayComm2WayInterface == null) {
      throw new IllegalArgumentException("displayComm2WayInterface cannot be null");
    }
    this.comm2Way = displayComm2WayInterface;
  }

  /**
  * Receives the rfid from User
  * before passing along to Comm2way.
  *
  * @return the TrackData
  */
  public TrackData receiveRfidRequest(int rfidNum) {
    this.data = comm2Way.passRfidRequest(rfidNum);

    System.out.println("Track Data for RFID tag number " + rfidNum);
    System.out.println("Location Data Points: " + data.getLocationDataPoints());
    System.out.println("Course Direction: " + data.getCourseDirection());
    System.out.println("Speed: " + data.getSpeed());
    System.out.println("Status: " + data.getStatusMessage());

    this.plotter = new TrackDataPlotter(data);
    plotter.displayPlot();

    return data;
  }
}
