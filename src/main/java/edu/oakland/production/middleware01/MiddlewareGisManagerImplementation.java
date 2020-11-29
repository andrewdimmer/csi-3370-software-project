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
    this.databaseGisInterface = databaseGisInterface;
    if (this.databaseGisInterface == null) {
      throw new IllegalArgumentException("database cannot be null");
    }
  }

  /**
   * Receives the signal strength from the Satellite.
   *
   * @return The name of the Satellite.
   */
  public String receiveGpsSignalStrength(Satellite satelliteSignal) {
    //storeLocationData();
    return satelliteSignal.getSatelliteName();
  }

  public void storeLocationDataPoint() {

  }

  /**
   * Attempts to regain the GPS lock.
   *
   * @return An empty string if successful.
   */
  public String attemptToRegainGpsLock(String satelliteName) {
    return "";
  }

  /**
   * Evaluates the Gps Signal Strength.
   *
   * @return The name of the satellite.
   */
  public String evaluateGpsSignalStrength(boolean signalValid) {
    if (signalValid == true) {
      databaseGisInterface.receiveModeRequest("normal");
      return "normal";
    } else {
      String name = satelliteSignal.getSatelliteName();
      String datapoint = databaseGisInterface.receiveNextSatRequest(name);
      
      if (datapoint.equals("")) {
        databaseGisInterface.receiveModeRequest("stand by");
        return "stand by";
      } else {
        databaseGisInterface.receiveModeRequest("degraded");
        return "degraded";
      }
    }
    //return satelliteSignal.getSatelliteName();        
  }
}