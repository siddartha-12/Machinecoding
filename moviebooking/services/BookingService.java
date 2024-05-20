package moviebooking.services;

import lombok.NonNull;
import moviebooking.LockProviders.LockProvider;
import moviebooking.models.Booking;
import moviebooking.models.Seat;
import moviebooking.models.Show;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    private final Map<String, Booking> showBookings;
    private final LockProvider seatLockProvider;

    public BookingService(LockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        this.showBookings = new HashMap<>();
    }

    public Booking getBooking(@NonNull final String bookingId) {
        if (!showBookings.containsKey(bookingId)) {
            // throwexception;
        }
        return showBookings.get(bookingId);
    }

    public List<Booking> getAllBookings(@NonNull final Show show) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking : showBookings.values()) {
            if (booking.getShow().equals(show)) {
                response.add(booking);
            }
        }

        return response;
    }

    public Booking createBooking(@NonNull final String userId, @NonNull final Show show,
                                 @NonNull final List<Seat> seats) {
        if (isAnySeatAlreadyBooked(show, seats)) {
//            throw new SeatPermanentlyUnavailableException();
            //throw exception
        }
        seatLockProvider.lockSeats(show, seats, userId);
        final String bookingId = UUID.randomUUID().toString();
        final Booking newBooking = new Booking(bookingId, show, seats, userId);
        showBookings.put(bookingId, newBooking);
        return newBooking;
        // TODO: Create timer for booking expiry
    }

    public List<Seat> getBookedSeats(@NonNull final Show show) {
        return getAllBookings(show).stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeatsBooked)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public void confirmBooking(@NonNull final Booking booking, @NonNull final String user) {
        if (!booking.getBookedByUser().equals(user)) {
            //throw new BadRequestException();
        }

        for (Seat seat : booking.getSeatsBooked()) {
            if (!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
                //throw new BadRequestException();
            }
        }
        booking.confirmBooking();
    }

    private boolean isAnySeatAlreadyBooked(final Show show, final List<Seat> seats) {
        final List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seats) {
            if (bookedSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }
}
