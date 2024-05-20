package moviebooking.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import moviebooking.models.Booking;
import moviebooking.models.Seat;
import moviebooking.models.Show;
import moviebooking.services.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingController {

    private final ShowService showService;
    private final BookingService bookingService;

    public String createBooking(@NonNull final String userId, @NonNull final String showId,
                                @NonNull final List<String> seatsIds) {
        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatsIds.stream().map(show.getScreen()::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId,show,seats).getId();
    }
}
