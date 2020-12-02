package edu.oakland.production.admin;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsInterface;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

/**
 * A production class to contain the GPS system object and satellites,
 * as well as iniate UC2 when the SLTS loses lock on GPS.
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
   * @param displayGpsInterfaceIn  The inputted GpsInterface to store.
   * @param satelliteNames  An array of Strings that will become satellites!
   *
   */
  public GpsSystem(DisplayGpsInterface displayGpsInterfaceIn, String[] satelliteNames) {
    if (displayGpsInterfaceIn == null) {  
      //3 checks to make sure the data that was passed in is valid
      throw new IllegalArgumentException("displayGpsInterface must not be null");
    } else if (satelliteNames == null) {
      throw new IllegalArgumentException("satelliteNames must not be null");
    } else if (isEmptyStringInArray(satelliteNames)) {
      throw new IllegalArgumentException("satelliteNames must not be null");
    }
    this.satellites = new Satellite[satelliteNames.length];
    this.displayGpsInterface = displayGpsInterfaceIn;
    
    configureSatellites(satelliteNames);
  }
  
  /**
   * Method to run UseCase 1, using supplied Scanner.
   *
   * @param input   The scanner object we are passing in.
   *
   */
  public void runUseCase1(Scanner input) {
    if (input == null) { //check for null unput
      throw new IllegalArgumentException("Scanner input must not be null");
    } 
  }
      
  /**
   * Method to run UseCase 2, using supplied Scanner.
   *
   * @param input   The scanner object we are passing in.
   *
   */
  public void runUseCase2(Scanner input) {
    if (input == null) { //check for null unput
      throw new IllegalArgumentException("Scanner input must not be null");
    }
  }
  
  /**
   * Method to set the instance variable satellites based on the paramaters that are passed in. 
   * Also makes each satellite have a random strength between 1 and 10.
   *
   * @param satelliteNames   Names for the satellites to create, as an array of strings
   * @param incrementLatAmount  amount to increment Lat for each satellite
   * @param incrementLngAmount  amount to increment Lng for each satellite
   * @param initLocationDataPoint  inital location data point to include with satellites
   *
   */
  public void configureSatellites(String[] satelliteNames, float incrementLatAmount, 
      float incrementLngAmount, LocationDataPoint initLocationDataPoint) {
    if (initLocationDataPoint == null) {
      throw new IllegalArgumentException("initLocationDataPoint must not be null");
    }
    
    Random rnd = new Random();
    for (int i = 0; i < satelliteNames.length; i++) {
      this.satellites[i] = new Satellite(satelliteNames[i], rnd.nextInt(10) + 1);
      this.satellites[i].satelliteInit(incrementLatAmount, 
          incrementLngAmount, initLocationDataPoint);
    }
  }
  
  /**
   * Method to generate the values for the public method with the same name,.
   * generating incrementLatAmount, incrementLngAmount, and initLocationDataPoint. 
   * With initLocationDataPoint, lat will be between 45.42 and 45.58, 
   * and lng will be between 44.42 and 45.58.
   *
   * @param satelliteNames   Array of strings, names of satellites provided by the constructor.
   *
   */
  private void configureSatellites(String[] satelliteNames) {
    Random rnd = new Random();
    
    float maxSpeedPerTick = (float) (.5 / 6);               
    //assumes up to 30 knots per hour and 10 minutes per ping
    float speed = (float) (maxSpeedPerTick - (rnd.nextFloat() * .02));
    
    float movementDirection = (float) (rnd.nextFloat() * (2 * Math.PI));  
    //direction and starting position for our LocationDataPoint
    float incrementLatAmount = (float) (speed * Math.sin(movementDirection));
    float incrementLngAmount = (float) (speed * -1 *  Math.cos(movementDirection));
    float lat = (float) ((rnd.nextFloat() * .16) + 45.42);
    float lng = (float) ((rnd.nextFloat() * 1.16) + 44.42);
    
    LocalDateTime time = LocalDateTime.now().minusMinutes(50);
    
    LocationDataPoint initLocationDataPoint = new LocationDataPoint(lat, lng, time);
    
    configureSatellites(satelliteNames, incrementLatAmount, incrementLngAmount, 
        initLocationDataPoint);
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