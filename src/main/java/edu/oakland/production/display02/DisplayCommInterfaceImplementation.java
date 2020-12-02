package edu.oakland.production.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommInterface;
import java.lang.IllegalArgumentException;
import java.util.Arrays;

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
    TrackData returnedTrackData = comm2Way.passRfidRequest(rfidNum);

    System.out.println("Course Direction: " + returnedTrackData.getCourseDirection());
    System.out.println("Speed: " + returnedTrackData.getSpeed());
    System.out.println("Location Data Points: " + Arrays.toString(returnedTrackData.getLocationDataPoints()));
    System.out.println("Status: " + returnedTrackData.getStatusMessage());

    TrackDataPlotter plotter = new TrackDataPlotter(returnedTrackData);
    plotter.displayPlot();

    return returnedTrackData;
  }
}
