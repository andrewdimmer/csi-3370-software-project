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
  private String savedSat = "";
  private String mode = "normal";


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

  /**
   * Store the location data point.
   *
   */
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
    String name = satellite.getSatelliteName();

    if (signalValid == true) {
      if (
          mode.equals("degraded") 
          &&
          databaseGisInterface.receiveNextSatRequest(name).length() > 0
      ) {
        // Upgrade from degraded to normal
        // Note: there is a special use case for the next satellite is empty, because that means
        // that there is still only one connected.
        databaseGisInterface.receiveModeRequest("normal");
        mode = "normal";
        System.out.println("Normal Mode");
      } else if (mode.equals("standby")) {
        // Upgrade from standby to degraded mode
        databaseGisInterface.receiveModeRequest("degraded");
        mode = "degraded";
        System.out.println("Degraded Mode");
      }
      return "N/A. Reconnected.";
    } else {
      // Retry the same satellite
      if (savedSat == "") {
        savedSat = name;
        return name;
      }
      savedSat = "";

      // Get the next satellite
      String datapoint = databaseGisInterface.receiveNextSatRequest(name);
      if (mode.equals("standby") || datapoint.equals("")) {
        databaseGisInterface.receiveModeRequest("standby");
        mode = "standby";
        System.out.println("Standby Mode");
        return "";
      } else {
        databaseGisInterface.receiveModeRequest("degraded");
        mode = "degraded";
        System.out.println("Degraded Mode");
        return databaseGisInterface.receiveNextSatRequest(name);
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