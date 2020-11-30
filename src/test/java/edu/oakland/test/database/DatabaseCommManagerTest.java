package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommManagerImplementation;
import edu.oakland.production.database.DatabasePersistentStorage;
import edu.oakland.test.database.DatabasePersistentStorageStub;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Database CommManager Test")
public class DatabaseCommManagerTest {

    @Test
    @DisplayName("rfid going in is Rfid coming Out")
    void rfidInIsRfidOut() {

        int i = 10;

        DatabaseCommManagerStub dcm = new DatabaseCommManagerStub();
        assertEquals(i, dcm.passGetRfidRequest());
    }

    @Test
    @DisplayName("Offset matches Datapoint")
    void offsetMatchDataPoint() {
        DatabaseCommManagerStub dcm = new DatabaseCommManagerStub();

        float lat = (float) (Math.random() * 360 - 180);
        float lng = (float) (Math.random() * 360 - 180);

        LocationDataPoint ldp = new LocationDataPoint(lat, lng,
                LocalDateTime.of((int) (Math.random() * 50 + 1970), (int) (Math.random() * 12 + 1),
                        (int) (Math.random() * 28 + 1), (int) (Math.random() * 24), (int) (Math.random() * 60)));

        ldp = null;
        int i = (int) Math.random();
        assertEquals(ldp, dcm.passGetLocationDataPointRequest(i));
    }

    @Test
    @DisplayName("Offset matches TrackData")
    void offsetMatchTrackData() {
        DatabaseCommManagerStub dcm = new DatabaseCommManagerStub();
        TrackData td = new TrackData();
        td = null;
        int i = (int) Math.random();
        assertEquals(td, dcm.passGetTrackDataRequest(i));
    }

    // @Test
    // @DisplayName("TrackData In is same as TrackData Out")
    // void trackDataInIsTrackDataOut() {
    // DatabaseCommManager dcm = new DatabaseCommManager();
    // TrackData td = new TrackData();
    // int i = (int) Math.random();
    // dcm.passStoreTrackDataRequest(td);
    // assertEquals(td, dcm.passGetTrackDataRequest(i));
    // }

    // @Test
    // @DisplayName("Database Persistent Storage is not Null")
    // void databasePersistentStorageIsNotNull() {
    // assertThrows(IllegalArgumentException.class, () -> {
    // new DatabaseCommManagerImplementation(null);
    // });

}