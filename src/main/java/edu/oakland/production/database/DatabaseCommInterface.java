package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;

public interface DatabaseCommManager {

	int receiveGetRfldRequest()
	LocationDataPoint receiveGetLocationDataPointRequest(Int offset)
	TrackData receiveGetTrackDataRequest(Int offset)
	void storeTrackDataRequest(TrackData trackData)
	String receiveGetModeRequest()

}