package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabasePersistentStorageClass {

  int rfidData;
  ArrayList<LocationDataPoint> locDataPoint = new ArrayList<LocationDataPoint>();
  ArrayList<TrackData> trackData = new ArrayList<TrackData>();
  String[] nextSatellites;
  String mode;

  /**
   * Creates the the class for managing the persistent storage
   * Provides rest of Database with functions
   *
   * @param rfidData the rfid integer
   * @param locDataPoint the location data point array list to initialize.
   * @param trackData the track data  array list to initialize.
   * @param nextSatellites the string array of satellites
   */
  public DatabasePersistentStorageClass(int rfidData, 
  ArrayList<LocationDataPoint> locDataPoint, 
  ArrayList<TrackData> trackData, 
  String[] nextSatellites) {
    this.rfidData = rfidData;
    this.locDataPoint = locDataPoint;
    this.trackData = trackData;
    this.nextSatellites = nextSatellites;
    this.mode = "normal";
  }



  public int locateRfidData() {
  	return rfidData;
  }

  public LocationDataPoint getLocationDataPoint(int offset) {

  	// If we have a trackdata of length 4 for example, then the offset can not be more than 3 so we use length-1
  	if (offset > this.locDataPoint.size()-1) {
  		// throw new IndexOutOfBoundsException("Offset " + offset + " is out of bounds!");
     return null;
    }

  	return this.locDataPoint.get(offset);
  }

  public void storeLocationDataPoint(LocationDataPoint locationDataPoint) {
    if (locationDataPoint == null) {
      throw new IllegalArgumentException("locationDataPoint cannot be null");
    }

    this.locDataPoint.add(locationDataPoint);
  }

  public TrackData getTrackData(int offset) {
    // If we have a trackdata of length 4 for example, then the offset can not be more than 3 so we use length-1
    if (offset > this.trackData.size()-1) {
      return null;
  	}

  	return this.trackData.get(offset);
  }

  public void storeTrackData(TrackData trackData) {
    if (trackData == null) {
      throw new IllegalArgumentException("trackData cannot be null");
    }

    this.trackData.add(trackData);
  }

  public String getMode() {
    return this.mode;
  }

  public void storeMode(String mode) {
    this.mode = mode;
  }

  /**
   * Finds the position of the currentSat providd
   * and retuns the the sat in the next position
   *
   * @param currentSat the current satellite string
   */
 public String getNextSat(String currentSat) {
    int satArrayLength = this.nextSatellites.length;
    int posOfCurrentSat = Arrays.asList(this.nextSatellites).indexOf(currentSat);

    boolean found = false;
    for (String sat : this.nextSatellites) {
      if (sat == currentSat){
        found = true;
      } 
    }

    if (!found)return "";

      if(satArrayLength - 1 > posOfCurrentSat){
        return this.nextSatellites[posOfCurrentSat + 1];
      } else {
        return "";
    }
  }

}

