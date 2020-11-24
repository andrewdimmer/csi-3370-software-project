package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;

public interface DatabaseGISInterface {
	
	public void receiveStoreRequest(LocationDataPoint locationDataPoint);
	
	public String receiveModeRequest(String Mode); 
	
	public String receiveNextSatRequest(String currentStat);
	
}