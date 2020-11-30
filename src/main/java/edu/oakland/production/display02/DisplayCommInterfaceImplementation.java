package edu.oakland.production.display02;

import edu.oakland.helper.admin.TrackData;


public class DisplayCommInterfaceImplementation implements DisplayCommInterface {
  public int rfid;
  DisplayComm2WayInterfaceImplementation instance = new DisplayComm2WayInterfaceImplementation();

  public TrackData receiveRfidRequest(int rfidNum) {
    rfid = rfidNum;
    TrackData trackData = instance.passRfidRequest(rfidNum);
    return trackData;
  }
}
