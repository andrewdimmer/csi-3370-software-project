package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public class DatabaseGisManagerImplementation implements DatabaseGisManager {

  DatabasePersistentStorage storage;

  /**
   * Creates a database manager that links the interface and storage.
   *
   * @param dps an instance of the DatabasePersistentStorage class.
   */
  public DatabaseGisManagerImplementation(DatabasePersistentStorage dps) {
    if (dps == null) {
      throw new IllegalArgumentException("storage cannot be null");
    }
    storage = dps;
  }

  public void passStoreRequest(LocationDataPoint locationDataPoint) {
    storage.storeLocationDataPoint(locationDataPoint);
  }

  public void passModeRequest(String mode) {
    storage.storeMode(mode);
  } 

  public String passNextSatRequest(String currentSat) {
    return storage.getNextSat(currentSat);
  }

}
