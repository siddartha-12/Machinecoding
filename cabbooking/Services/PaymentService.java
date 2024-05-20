package cabbooking.Services;

import cabbooking.models.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private final Map<String, Payment> paymentMap;

    public PaymentService() {
        this.paymentMap = new HashMap<>();
    }

    public boolean makePayment(Payment payment)
    {
        paymentMap.put(payment.getId(),payment);
        payment.markCompleted();
        return true;
    }
}
