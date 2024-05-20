package cabbooking.strategies;

import cabbooking.models.Location;

public class DefaultpriceStrategy implements PriceStrategy{
    @Override
    public Integer matchPrice(Location from, Location to) {
        return 100;
    }
}
