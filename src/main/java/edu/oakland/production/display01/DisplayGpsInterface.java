package main.java.edu.oakland.production;

public interface DisplayGpsInterface {

    public void recieveGPSSingnals(Satellite satelliteSignal);

    public void reportGpsSignalLoss(String satelliteName);

    public void recheckSignalStrength(String satelliteName);

    public void checkSignalStrength(String satelliteName);
}