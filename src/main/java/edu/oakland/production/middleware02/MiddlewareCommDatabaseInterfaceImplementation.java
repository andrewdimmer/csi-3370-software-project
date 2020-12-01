package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;


public class MiddlewareCommDatabaseInterfaceImplementation implements 
      MiddlewareCommDatabaseInterface {
  int rfid;
  
  private DatabaseCommInterface databaseCommInterface;
  
  public 
      MiddlewareCommDatabaseInterfaceImplementation(DatabaseCommInterface databaseCommInterface) {
    if (databaseCommInterface == null) {
      throw new IllegalArgumentException("databaseCommInterface cannot be null");
    }
        
    this.databaseCommInterface = databaseCommInterface;
  }
  
  public int checkCurrentRfid() {
    return databaseCommInterface.receiveGetRfidRequest();
  } 
}
