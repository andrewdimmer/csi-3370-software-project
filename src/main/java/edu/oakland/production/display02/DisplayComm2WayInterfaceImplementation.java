package edu.oakland.production.display02;

import edu.oakland.helper.admin.TrackData;

public class DisplayComm2WayInterfaceImplementation implements DisplayComm2WayInterface {

  DisplayCommManagerImplementation commManager = new DisplayCommManagerImplementation();

  public TrackData receiveRfidRequest(int rfidNum) {
      return determineUserRequestFormat(rfidNum);
  }
  private TrackData determineUserRequestFormat(int rfidNum) {
    return passRfidRequest(rfidNum);
  }
  public TrackData passRfidRequest(int rfidNum) {
    return commManager.receiveRfid(rfidNum);
  }

}
