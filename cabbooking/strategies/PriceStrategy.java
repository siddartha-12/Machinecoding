package cabbooking.strategies;

import cabbooking.models.Location;

public interface PriceStrategy {
    public Integer matchPrice(Location from, Location to);
}
