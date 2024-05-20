package cabbooking.strategies;

import cabbooking.models.Cab;
import cabbooking.models.Location;
import cabbooking.models.Rider;

import java.util.List;

public interface CarMatchingStrategy {

    public Cab matchCarToRider(Rider rider, Location from, List<Cab> cabList);
}
