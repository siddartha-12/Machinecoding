package moviebooking.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import moviebooking.services.BookingService;
import moviebooking.services.PaymentService;

public class PaymentController {
    private final PaymentService paymentsService;
    private final BookingService bookingService;

    public PaymentController(PaymentService paymentsService, BookingService bookingService) {
        this.paymentsService = paymentsService;
        this.bookingService = bookingService;
    }

    public void paymentFailed(@NonNull final String bookingId, @NonNull final String user) {
        paymentsService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public void paymentSuccess(@NonNull final  String bookingId, @NonNull final String user) {
        bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
    }
}
