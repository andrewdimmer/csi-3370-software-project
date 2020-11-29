package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.database.DatabaseGisInterface;
import java.time.LocalDateTime;

public class MiddlewareGisManagerImplementation implements MiddlewareGisManager {
    
  private DatabaseGisInterface databaseGisInterface;
  private LocationDataPoint locationDataPoint;
  private Satellite satelliteSignal;

  public MiddlewareGisManagerImplementation (DatabaseGisInterface databaseGisInterface) {
    this.databaseGisInterface = databaseGisInterface;
  }

  public String receiveGpsSignalStrength (Satellite satelliteSignal) {
    //storeLocationData();
    return satelliteSignal.getSatelliteName();
  }

  public void storeLocationDataPoint() {

  }

  public String attemptToRegainGpsLock(String satilliteName) {
    return "";
  }

  public String evaluateGpsSignalStrength(boolean signalValid) {

    if (signalValid == true) {
      databaseGisInterface.receiveModeRequest("normal");
      return "";
    } else {
      String datapoint = databaseGisInterface.receiveNextSatRequest(satelliteSignal.getSatelliteName());
      if (datapoint.equals("")){
        databaseGisInterface.receiveModeRequest("stand by");
      } else {
        databaseGisInterface.receiveModeRequest("degraded");
      }  
      return satelliteSignal.getSatelliteName();
    }
              
  }

}