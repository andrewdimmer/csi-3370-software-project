package edu.oakland.test.display01;


import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;


public class DisplayGpsManagerStub {

    private String checkType = "oreo";
    public SatelliteSignalCheckRequest receiveGpsSignalStrength(Satellite satelliteSignal) {
        SatelliteSignalCheckRequest ssrc = new SatelliteSignalCheckRequest(satelliteSignal.getSatelliteName(), checkType);
            return ssrc;
      }



    public SatelliteSignalCheckRequest passGpsSignalStrength(String satelliteName){
        SatelliteSignalCheckRequest ssrc = new SatelliteSignalCheckRequest(satelliteName, checkType);
            return ssrc;
            
    }

    }
