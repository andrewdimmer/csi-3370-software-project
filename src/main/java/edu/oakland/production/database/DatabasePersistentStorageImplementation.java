package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabasePersistentStorageImplementation implements DatabasePersistentStorage {

  int rfidData;
  ArrayList<LocationDataPoint> locDataPoint = new ArrayList<LocationDataPoint>();
  ArrayList<TrackData> trackData = new ArrayList<TrackData>();
  String[] nextSatellites;
  String mode;

  /**
   * Creates the the class for managing the persistent storage.
   * Provides rest of Database with functions.
   *
   * @param rfidData the rfid integer.
   * @param locDataPoint the location data point array list to initialize.
   * @param trackData the track data  array list to initialize.
   * @param nextSatellites the string array of satellites.
   */
  public DatabasePersistentStorageImplementation(int rfidData, 
      ArrayList<LocationDataPoint> locDataPoint, 
      ArrayList<TrackData> trackData, 
      String[] nextSatellites) {

    if (locDataPoint == null) {
      throw new IllegalArgumentException("locationDataPoint cannot be null");
    }

    if (trackData == null) {
      throw new IllegalArgumentException("trackData cannot be null");
    }

    if (nextSatellites == null) {
      throw new IllegalArgumentException("nextSatellites cannot be null");
    }

    this.rfidData = rfidData;
    this.locDataPoint = locDataPoint;
    this.trackData = trackData;
    this.nextSatellites = nextSatellites;
    this.mode = "normal";
  }


  /**
   * Returns the rfidData integer.
   * 
   *
   * 
   * 
   * 
   * 
   */

  public int locateRfidData() {
    return rfidData;
  }

  /**
   * Returns a locationpoint point.
   * after providing the offset.
   *
   * @param offset the offset (int) of the data needed.
   */

  public LocationDataPoint getLocationDataPoint(int offset) {

    // If trackdata has size of length 4 , then the offset can not be > 3 so we use size-1
    if (offset > this.locDataPoint.size() - 1) {
      return null;
    }

    return this.locDataPoint.get(offset);
  }

  /**
   * Takes a location data point and stores it.
   *
   *
   * @param locationDataPoint the locationDataPoint data type.
   */

  public void storeLocationDataPoint(LocationDataPoint locationDataPoint) {
    if (locationDataPoint == null) {
      throw new IllegalArgumentException("locationDataPoint cannot be null");
    }

    this.locDataPoint.add(0, locationDataPoint);
  }

  /**
   * Retrieve track data.
   *
   *
   * @param offset the offset (int) of the track data needed.
   */

  public TrackData getTrackData(int offset) {
    // If we have a td of L=4, then the offset can't be >3 so we use length-1
    if (offset > this.trackData.size() - 1) {
      return new TrackData(new LocationDataPoint[0]);
    }

    return this.trackData.get(offset);
  }

  /**
   * Store track data.
   *
   *
   * @param trackData the track data provided in the trackData data type.
   */

  public void storeTrackData(TrackData trackData) {
    if (trackData == null) {
      throw new IllegalArgumentException("trackData cannot be null");
    }

    this.trackData.add(0, trackData);
  }

  /**
   * Returns the mode.
   *
   *
   *
   */

  public String getMode() {
    return this.mode;
  }

  /**
   * Stores the mode.
   *
   *
   * @param mode The mode to utilize in string format.
   */

  public void storeMode(String mode) {
    this.mode = mode;
  }

  /**
   * Finds the position of the currentSat provided.
   * and retuns the the sat in the next position.
   *
   * @param currentSat the current satellite string
   */
  public String getNextSat(String currentSat) {
    int satArrayLength = this.nextSatellites.length;
    int posOfCurrentSat = Arrays.asList(this.nextSatellites).indexOf(currentSat);

    boolean found = false;
    for (String sat : this.nextSatellites) {
      if (sat == currentSat) {
        found = true;
      } 
    }

    if (!found) {
      return "";
    }

    if (satArrayLength - 1 > posOfCurrentSat) {
      return this.nextSatellites[posOfCurrentSat + 1];
    } else {
      return "";
    }
  }

}
