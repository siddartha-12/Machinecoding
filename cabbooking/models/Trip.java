package cabbooking.models;

public class Trip {
    private final String id;
    private final Rider rider;
    private final Cab cab;
    private TripStatus tripStatus;
    private final Location startLocation;
    private final Location destinationLocation;
    private final String bookingId;


    public Trip(String id, Rider rider, Cab cab, Location startLocation, Location destinationLocation, String bookingId) {
        this.id = id;
        this.rider = rider;
        this.cab = cab;
        this.startLocation = startLocation;
        this.destinationLocation = destinationLocation;
        this.bookingId = bookingId;
        this.tripStatus = TripStatus.Started;
    }

    public Location getCurrentLocation(){
        return this.cab.getCurrentLocation();
    }
    public void markCompleted(){
        this.tripStatus = TripStatus.Completed;
    }

    public void markInProgress(){
        this.tripStatus = TripStatus.InProgress;
    }
}
