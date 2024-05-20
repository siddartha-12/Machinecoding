package moviebooking.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Booking {
    private final String id;
    private final Show show;
    private final List<Seat> seatsBooked;
    private BookingStatus bookingStatus;
    private final String bookedByUser;

    public Booking(String id, Show show, List<Seat> seatsBooked, String bookedByUser) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.bookedByUser = bookedByUser;
        this.bookingStatus = BookingStatus.Created;
    }

    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.Confirmed;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.Created) {
            //exception
        }
        this.bookingStatus = BookingStatus.Confirmed;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.Created) {
            //exception
        }
        this.bookingStatus = BookingStatus.Expired;
    }
}
