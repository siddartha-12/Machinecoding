package cabbooking.models;

import lombok.Getter;
import parkinglot.Vechile;

@Getter
public class Driver {
    private final String id;
    private final String name;
    private boolean isAvailable;
    private String city;

    public Driver(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        isAvailable = false;
    }
    public void toggleAvaialable(){
        this.isAvailable = !this.isAvailable;
    }

}
