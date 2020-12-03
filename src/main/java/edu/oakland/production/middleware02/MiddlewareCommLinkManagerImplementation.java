package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.middleware02.TrackDataCalculator;
import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterfaceImplementation;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;
import java.util.ArrayList;
import java.util.Collections;


public class MiddlewareCommLinkManagerImplementation implements MiddlewareCommLinkManager {

  private MiddlewareCommDatabaseInterface midDatabaseInterface;
  private MiddlewareGisManager gisManager;
  //private LocationDataPoint[] locationDataPoint = new LocationDataPoint();

  /**
   * The constructor for MiddlewareCommLinkManagerImplementation.
   */
  
  public MiddlewareCommLinkManagerImplementation(
      MiddlewareCommDatabaseInterface midDatabaseInterface,
      MiddlewareGisManager gisManager
  ) {
    if (midDatabaseInterface == null) {
      throw new IllegalArgumentException("midDatabaseInterface cannot be null");
    }
    if (gisManager == null) {
      throw new IllegalArgumentException("gisManager cannot be null");
    }

    this.midDatabaseInterface = midDatabaseInterface;
    this.gisManager = gisManager;
  }
  
  /**
  * Method to parse the Rfid with a mode check.
  */
  public TrackData parseRfid(int rfid) {
    if (midDatabaseInterface.checkCurrentRfid() != rfid) {
      TrackData trackData = new TrackData(new LocationDataPoint[0]);
      trackData.setStatusMessage("The system RFID does not match the requested RFID.");
      return trackData;
    } else if (midDatabaseInterface.requestMode() == "normal") {
        gisManager.storeLocationDataPoint();
        return calculateLocationData();
    } else {
      TrackData trackData = midDatabaseInterface.getTrackData();
      trackData.setStatusMessage("The system is in " + midDatabaseInterface.requestMode()
                                 + " mode ... getting historical data...");
      return trackData;
    } 
  }

  private TrackData calculateLocationData() {
    ArrayList<LocationDataPoint> points = new ArrayList<LocationDataPoint>();
      
    for (int i = 0; i < 5; i++) {
      LocationDataPoint point = midDatabaseInterface.getLocationDataPoint(i);
      if (point == null) {
        break;
      }
      points.add(point);
    }
    
    LocationDataPoint[] pointsForCalculations = new LocationDataPoint[points.size()];
    points.toArray(pointsForCalculations);
    
    if (pointsForCalculations.length != 5) {
      TrackData trackData = new TrackData(pointsForCalculations);
      trackData.setStatusMessage("The system is in normal mode, but there's not enough data to"
                                 + " conduct calculations for speed and direction.");
      return trackData;
    } 
      
    float speed = TrackDataCalculator.calculateSpeed(pointsForCalculations);
    float direction = TrackDataCalculator.calculateDirection(pointsForCalculations);
    TrackData trackData = new TrackData(pointsForCalculations, direction, speed);
    trackData.setStatusMessage("The system is in normal mode and has enough data to calculate"
                               + " the speed and direction of the shipping container.");
    midDatabaseInterface.storeTrackData(trackData);
    return trackData;
  }

}
