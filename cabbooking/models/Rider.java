package cabbooking.models;

import lombok.Getter;

@Getter
public class Rider {
    private String id;
    private String name;
    private Location currentLocation;
    private String city;

    public Rider(String city, String id, String name) {
        this.city = city;
        this.id = id;
        this.name = name;
        this.currentLocation = new Location(0,0);
    }
}
