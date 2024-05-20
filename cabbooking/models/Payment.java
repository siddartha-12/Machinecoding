package cabbooking.models;

import lombok.Getter;

@Getter
public class Payment {
    private final String id;
    private final double amount;
    private PaymentStatus paymentStatus;
    private final Rider rider;
    private final String bookingId;

    public Payment(String id, double amount, Rider rider, String bookingId) {
        this.id = id;
        this.amount = amount;
        this.rider = rider;
        this.bookingId = bookingId;
        paymentStatus = PaymentStatus.Created;
    }
    public void markCompleted(){
        paymentStatus = PaymentStatus.Completed;
    }
    public void markFailed(){
        paymentStatus = PaymentStatus.Failed;
    }
}
