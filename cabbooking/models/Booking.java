package cabbooking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class Booking {
    private final String id;
    private final String bookedRiderId;
    private Trip trip;

    public void setTrip(Trip trip){
        this.trip = trip;
    }

}
