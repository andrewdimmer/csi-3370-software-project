package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;

public interface DatabaseCommInterface {

  int receiveGetRfidRequest();

  LocationDataPoint receiveGetLocationDataPointRequest(int offset);

  TrackData receiveGetTrackDataRequest(int offset);

  void storeTrackDataRequest(TrackData trackData);
  
  String receiveGetModeRequest();

}
