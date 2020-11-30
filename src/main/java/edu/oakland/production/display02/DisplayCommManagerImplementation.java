package edu.oakland.production.display02;

import edu.oakland.helper.admin.*;
import edu.oakland.production.display02.DisplayCommManager;
import edu.oakland.production.middleware02.MiddlewareCommInterface;
import java.lang.IllegalArgumentException;

public class DisplayCommManagerImplementation implements DisplayCommManager {

    MiddlewareCommInterface middleware;

    public int rfid;

    public TrackData receiveRfid(int rfidNum){
        rfid = rfidNum;
        return evaluateRfidRequest(rfid);
    }

    public TrackData evaluateRfidRequest(int rfid) {
        return passRfidToMiddlewareCommInterface(rfid);
    }

    public TrackData passRfidToMiddlewareCommInterface(int rfid){
        if (middleware == null) {
            throw new IllegalArgumentException("MiddlewareCommInterface cannot be null");
        }
        return middleware.requestRfid(rfid);
    }

}
