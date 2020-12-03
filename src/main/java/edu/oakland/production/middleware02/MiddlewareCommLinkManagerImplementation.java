package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
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
    this.midDatabaseInterface = midDatabaseInterface;

    if (gisManager == null) {
      throw new IllegalArgumentException("gisManager cannot be null");
    }
    this.gisManager = gisManager;
  }

  public TrackData parseRfid(int rfid) {
    TrackData trackData;
    trackData = new TrackData(new LocationDataPoint[0]);
    if (midDatabaseInterface.checkCurrentRfid() != rfid) {
      trackData = new TrackData(new LocationDataPoint[0]);
      trackData.setStatusMessage("There's no match, exiting SLTS."); //Concat Later
      
    } else { 
      gisManager.storeLocationDataPoint();
      if (midDatabaseInterface.requestMode() == "normal") {
        calculateLocationData();
      } else {
        trackData = midDatabaseInterface.getTrackData();
        trackData.setStatusMessage("Getting Historical Data"); //Concat Later
      } 
    } 
    return trackData;
  }

  private TrackData calculateLocationData() {
    ArrayList<LocationDataPoint> points = new ArrayList<LocationDataPoint>();
    TrackData trackData = midDatabaseInterface.getTrackData();
      
    float speed;
    float direction;
      
    for (int i = 0; i < 5; i++) {
      if (midDatabaseInterface.getLocationDataPoint(i) == null) {
        break;
      }
      LocationDataPoint newPoint = midDatabaseInterface.getLocationDataPoint(i);
      points.add(newPoint);

    }
    
    Collections.reverse(points);
    LocationDataPoint[] pointsForCalculations = new LocationDataPoint[points.size()];
    points.toArray(pointsForCalculations);   

    if (pointsForCalculations.length != 5) {
      trackData.setStatusMessage("There's not enough data to conduct calculations" + 
                                 "for speed and direction.");
    } 
      
    //speed = calculateSpeed(pointsForCalculations);
    //direction = calculateDirection(pointsForCalculations);
      
    //TrackData returnTrackData = new TrackData(pointsForCalculations, direction, speed);
    
    return trackData;
  } 

  //private float calculateTrackData() {
    
  //}

}
