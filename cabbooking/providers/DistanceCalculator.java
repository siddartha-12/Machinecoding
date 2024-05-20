package cabbooking.providers;

import cabbooking.models.Location;

public class DistanceCalculator {
    public static double distance(Location location, Location location2){
        return Math.sqrt(square(location.getX()- location2.getX())+square(location.getY()- location2.getY()));
    }
    private static double square(Integer x){
        return x*x;
    }
}
