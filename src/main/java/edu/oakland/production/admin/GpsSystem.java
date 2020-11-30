package edu.oakland.production.admin;

import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;

import edu.oakland.test.admin.DisplayGpsInterfaceStub;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.admin.LocationDataPoint;


/**
 * A production class to contain the GPS system object and satellites, as well as iniate UC2 when the SLTS loses lock on GPS.
 *
 * @author Brendan Fraser
 * @version %I%, %G%
 */
public class GpsSystem {

  final DisplayGpsInterfaceStub displayGpsInterface;
  final Satellite[] satellites;


  /**
   * Creates a GpsSystem object to store the GpsInterface and satellites.
   *
   * @param displayGpsInterface  The inputted GpsInterface to store.
   * @param satelliteNames  An array of Strings that will become satellites!
   *
   */
  public GpsSystem(DisplayGpsInterfaceStub displayGpsInterface, String[] satelliteNames) {
	  satellites = new Satellite[10];
	  
  }

}