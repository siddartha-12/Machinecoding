package cabbooking.Services;

import cabbooking.exceptions.NoCarsAvailableException;
import cabbooking.models.*;
import cabbooking.strategies.CarMatchingStrategy;
import cabbooking.strategies.PriceStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {
    private final Integer MAX_CIRCLE_RADIUS = 1000;
    private final Map<String,Booking> bookingMap;
    private final RiderService riderService;
    private final CabService cabService;
    private final PaymentService paymentService;
    private final CarMatchingStrategy carMatchingStrategy;
    private final PriceStrategy priceStrategy;

    public BookingService(RiderService riderService, CabService cabService, PaymentService paymentService, CarMatchingStrategy carMatchingStrategy, PriceStrategy priceStrategy) {
        this.riderService = riderService;
        this.cabService = cabService;
        this.paymentService = paymentService;
        this.carMatchingStrategy = carMatchingStrategy;
        this.priceStrategy = priceStrategy;
        this.bookingMap = new HashMap<>();
    }

    public List<Booking>  getBookingForRider(String riderId){
        return bookingMap.values().stream()
                .filter((booking -> booking.getBookedRiderId().equals(riderId)))
                .toList();
    }

    public Booking bookCab(String riderId, Location destination){
        Rider rider = riderService.getRider(riderId);
        List<Cab> cabs = cabService.getAvailableCabsForLocationWithInMetres(rider.getCurrentLocation(),MAX_CIRCLE_RADIUS,rider.getCity());
        if(cabs.size()>0){
            Cab nearestCab = carMatchingStrategy.matchCarToRider(rider,rider.getCurrentLocation(),cabs);
            nearestCab.markTemporarilyUnAvailable();
            Booking booking = new Booking(UUID.randomUUID().toString(), riderId,null);
            Payment payment = new Payment(UUID.randomUUID().toString(),priceStrategy.matchPrice(rider.getCurrentLocation(), destination),rider,booking.getId());
            bookingMap.put(booking.getId(),booking);
            if(paymentService.makePayment(payment)){
                Trip trip = new Trip(UUID.randomUUID().toString(),rider,nearestCab,rider.getCurrentLocation(),null,booking.getId());
                booking.setTrip(trip);
            }
            else {
                nearestCab.markAvailable();
            }
            return booking;

        }
        else {
            throw new NoCarsAvailableException();
        }
    }
}
