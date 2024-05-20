package cabbooking.models;

import lombok.Getter;

@Getter
public class Cab {
    private final String id;
    private final String name;
    private Driver driver;
    private Location currentLocation;
    private CarStatus carStatus;

    public Cab(String id, String name, Driver driver) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.currentLocation = new Location(0,0);
        this.carStatus = CarStatus.Available;
    }
    public synchronized void markUnavailable(){
        this.carStatus = CarStatus.UnAvailable;
    }

    public synchronized void markTemporarilyUnAvailable(){
        this.carStatus = CarStatus.Temporarily_UnAvailable;
    }
    public synchronized void markAvailable(){
        this.carStatus = CarStatus.Available;
    }


}
