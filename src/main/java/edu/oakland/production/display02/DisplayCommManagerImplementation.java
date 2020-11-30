package edu.oakland.production.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayCommManager;
import edu.oakland.production.middleware02.MiddlewareCommInterface;
import java.lang.IllegalArgumentException;

/**
* This class receives the rfid, evaluates it,
* then passes it along to Middleware.
*
*/
public class DisplayCommManagerImplementation implements DisplayCommManager {

    private MiddlewareCommInterface middleware;
    
    /**
    * Creates a DisplayCommManagerImplementation to receive the rfid.
    *
    * param MiddlewareCommInterface: The class that DisplayCommManager will pass the rfid to.
    *
    */
    public DisplayCommManagerImplementation(MiddlewareCommInterface middlewareCommInterface) {
        if (middlewareCommInterface == null) {
            throw new IllegalArgumentException("processor cannot be null");
        }
        this.middleware = middlewareCommInterface;
    }

    /**
    * Receives the rfid from DisplayComm2WayInterface
    * before passing along for evaluation.
    *
    * @return the TrackData
    */
    public TrackData receiveRfid(int rfidNum) {
        return evaluateRfidRequest(rfid);
    }

    /**
    * Evaluates the rfid received.
    *
    * @return the TrackData
    */
    public TrackData evaluateRfidRequest(int rfid) {
        return passRfidToMiddlewareCommInterface(rfid);
    }

    /**
    * Passes the evaluated rfid along to MiddlewareCommInterface.
    *
    * @return the TrackData
    */
    public TrackData passRfidToMiddlewareCommInterface(int rfid) {
        if (middleware == null) {
            throw new IllegalArgumentException("MiddlewareCommInterface cannot be null");
        }
        return middleware.requestRfid(rfid);
    }

}
