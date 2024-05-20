package moviebooking.services;

import lombok.NonNull;
import moviebooking.LockProviders.LockProvider;
import moviebooking.models.Seat;
import moviebooking.models.Show;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {
    private final BookingService bookingService;
    private final LockProvider seatLockProvider;

    public SeatAvailabilityService(@NonNull final BookingService bookingService,
                                   @NonNull final LockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(@NonNull final Show show) {
        final List<Seat> allSeats = (List<Seat>) show.getScreen().getSeats().values();
        final List<Seat> unavailableSeats = getUnavailableSeats(show);

        final List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(unavailableSeats);
        return availableSeats;
    }

    private List<Seat> getUnavailableSeats(@NonNull final Show show) {
        final List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;
    }
}
