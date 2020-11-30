package edu.oakland.production.admin;

import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

import edu.oakland.production.display01.DisplayGpsInterface;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.admin.LocationDataPoint;


/**
 * A production class to contain the GPS system object and satellites, as well as iniate UC2 when the SLTS loses lock on GPS.
 *
 * @author Brendan Fraser
 * @version %I%, %G%
 */
public class GpsSystem {

  private final DisplayGpsInterface displayGpsInterface;
  private final Satellite[] satellites;

  /**
   * Creates a GpsSystem object to store the GpsInterface and satellites.
   *
   * @param displayGpsInterface  The inputted GpsInterface to store.
   * @param satelliteNames  An array of Strings that will become satellites!
   *
   */
  public GpsSystem(DisplayGpsInterface displayGpsInterfaceIn, String[] satelliteNames) {
    if (displayGpsInterfaceIn == null) {  //3 checks to make sure the data that was passed in is valid
		  throw new IllegalArgumentException("displayGpsInterface must not be null");
	  } else if (satelliteNames == null) {
      throw new IllegalArgumentException("satelliteNames must not be null");
	  } else if (isEmptyStringInArray(satelliteNames)) {
		  throw new IllegalArgumentException("satelliteNames must not be null");
	  }
	  satellites = new Satellite[satelliteNames.length];
	  displayGpsInterface = displayGpsInterfaceIn;
  }
  
  /**
   * Method to run UseCase 1, using supplied Scanner
   *
   * @param input   The scanner object we are passing in.
   *
   */
  public void runUseCase1(Scanner input) {
    if (input == null) { //check for null unput
      throw new IllegalArgumentException("Scanner input must not be null");
    } 
    if (!this.displayGpsInterface.receiveGpsSignal(this.satellites[0])) {
      runUseCase2(input);
    } 
  }
      
  /**
   * Method to run UseCase 2, using supplied Scanner
   *
   * @param input   The scanner object we are passing in.
   *
   */
  public void runUseCase2(Scanner input) {
    if (input == null) { //check for null unput
      throw new IllegalArgumentException("Scanner input must not be null");
    }
  }
  
  public void configureSatellites(String[] satelliteNames, float incrementLatAmount, float incrementLngAmount, LocationDataPoint initLocationDataPoint) {
  }
  
  /**
   * Checks if all strings in input array are of length > 0.
   *
   * @param in  The inputted array of strings.
   *
   */
  private boolean isEmptyStringInArray(String[] in) {
    for (int i = 0; i < in.length; i++) {
      if (in[i].length() == 0) {
        return true;
      }
    }
    return false;
  }
}