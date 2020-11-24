package edu.oakland.production.database;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.database;
import edu.oakland.test.database;

public interface DatabaseCommManager {

    public int passGetRfidRequest();

    public LocationDataPoint passGetLocationDataPointRequest(int offset);

    public TrackData passGetTrackDataRequest(int offset);

    public void passStoreTrackDataRequest(TrackData trackData);
    
    public String passGetModeRequest();

    
}
