package moviebooking.services;

import lombok.NonNull;
import moviebooking.LockProviders.LockProvider;
import moviebooking.models.Booking;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    Map<Booking, Integer> bookingFailures;
    private final Integer allowedRetries;
    private final LockProvider seatLockProvider;

    public PaymentService(@NonNull final Integer allowedRetries, LockProvider seatLockProvider) {
        this.allowedRetries = allowedRetries;
        this.seatLockProvider = seatLockProvider;
        bookingFailures = new HashMap<>();
    }

    public void processPaymentFailed(@NonNull final Booking booking, @NonNull final String user) {
        if (!booking.getBookedByUser().equals(user)) {
            //throw new BadRequestException();
        }
        if (!bookingFailures.containsKey(booking)) {
            bookingFailures.put(booking, 0);
        }
        final Integer currentFailuresCount = bookingFailures.get(booking);
        final Integer newFailuresCount = currentFailuresCount + 1;
        bookingFailures.put(booking, newFailuresCount);
        if (newFailuresCount > allowedRetries) {
            seatLockProvider.unlockSeats(booking.getShow(), booking.getSeatsBooked(), booking.getBookedByUser());
        }
    }
}
