package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.database.DatabaseGisInterface;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import java.time.LocalDateTime;

/**
 * This class shall receive the Satellite signal, 
 * store the data point and pass the signal to the database 
 * or attempt to regain GPS lock and evaluate the signal strength.
 *
 */
public class MiddlewareGisManagerImplementation implements MiddlewareGisManager {
    
  private DatabaseGisInterface databaseGisInterface;
  private LocationDataPoint locationDataPoint;
  private Satellite satelliteSignal;

  /**
   * Creates a MiddlewareGisManagerImplementation to receive the Satellite signal.
   *
   * @param databaseGisInterface  The class that this class will pass the Satellite signal to.
   *
   */
  public MiddlewareGisManagerImplementation(DatabaseGisInterface databaseGisInterface) {
    if (databaseGisInterface == null) {
      throw new IllegalArgumentException("database cannot be null");
    }
    this.databaseGisInterface = databaseGisInterface;
  }

  /**
   * Receives the signal strength from the Satellite.
   *
   * @return The name of the Satellite.
   */
  public String receiveGpsSignalStrength(Satellite satelliteSignal) {
    if (isStrongEnough(satelliteSignal.getStrength())) {
      locationDataPoint = satelliteSignal.getLocation();
      return "GPS signal was strong enough, saving location data point";
    } else {
      return "GPS signal was not strong enough, starting use case 2";
    }
  }

  public void storeLocationDataPoint() {
    if (locationDataPoint != null) {
      databaseGisInterface.receiveStoreRequest(locationDataPoint);
    }
  }

  /**
   * Evaluates the Gps Signal Strength.
   *
   * @return The name of the satellite.
   */
  public String evaluateGpsSignalStrength(Satellite satellite) {
    boolean signalValid = isStrongEnough(satellite.getStrength());

    if (signalValid == true) {
      databaseGisInterface.receiveModeRequest("normal");
      return "normal";
    } else {
      String name = satellite.getSatelliteName();
      String datapoint = databaseGisInterface.receiveNextSatRequest(name);
      if (datapoint.equals("")) {
        databaseGisInterface.receiveModeRequest("stand by");
        return "stand by";
      } else {
        databaseGisInterface.receiveModeRequest("degraded");
        return "degraded";
      }
    }     
  }  
  
  /**
   * Is the signal strength strong enough.
   *
   * @return True or false.
   */
  private boolean isStrongEnough(int strength) {
    return strength >= 4;
  }
}