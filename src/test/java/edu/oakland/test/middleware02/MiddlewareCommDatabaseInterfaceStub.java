package edu.oakland.test.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;

public class MiddlewareCommDatabaseInterfaceStub implements MiddlewareCommDatabaseInterface {

  private int rfid;
  private String mode;
  private LocationDataPoint[] points;
  private TrackData trackData;
  
  /**
   * Creates a test stub to simulate MiddlewareCommDatabaseInterface.
   */
  public MiddlewareCommDatabaseInterfaceStub(int rfid) {
    this.rfid = rfid;
  }

  /**
   * Creates a test stub to simulate MiddlewareCommDatabaseInterface.
   */
  public MiddlewareCommDatabaseInterfaceStub(
      int rfid,
      String mode,
      LocationDataPoint[] points,
      TrackData trackData
  ) {
    this.rfid = rfid;
    this.mode = mode;
    this.points = points;
    this.trackData = trackData;
  }

  public int checkCurrentRfid() {
    return rfid;
  }

  public String requestMode() {
    return mode;
  }

  public TrackData getTrackData() {
    return trackData;
  }

  public void storeTrackData(TrackData trackData) {
    this.trackData = trackData;
  }

  /**
   * Simulates getLocationDataPoint in MiddlewareCommDatabaseInterface.
   */
  public LocationDataPoint getLocationDataPoint(int offset) {
    if (offset >= points.length) {
      return null;
    }
    return points[offset];
  }
  
}