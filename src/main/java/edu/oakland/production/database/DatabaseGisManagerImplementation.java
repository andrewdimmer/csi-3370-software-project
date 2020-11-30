package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public class DatabaseGisManagerImplementation implements DatabaseGisManager {

 LocationDataPoint locDataPoint;
 String Mode;
 String currentSat;
 DatabasePersistentStorage dps = new DatabasePersistentStorage();

  public DatabaseGisManagerImplementation(DatabasePersistentStorage databasePersistentStorage) {
     dps = databasePersistentStorage;
      }

  public void passStoreRequest(LocationDataPoint locationDataPoint) {
	     dps.storeLocationDataPoint(locationDataPoint);
      }

  public void passModeRequest(String mode) {
	     dps.storeMode(mode);
      } 

  public String passNextSatRequest(String currentSat) {
         return dps.getNextSat(currentSat); 
  }

}