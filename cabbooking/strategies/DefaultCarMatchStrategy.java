package cabbooking.strategies;

import cabbooking.models.Cab;
import cabbooking.models.Location;
import cabbooking.models.Rider;
import cabbooking.providers.DistanceCalculator;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DefaultCarMatchStrategy implements CarMatchingStrategy{
    @Override
    public Cab matchCarToRider(Rider rider, Location from, List<Cab> cabList) {
        Queue<Cab> cabQueue = new PriorityQueue<>((cab1, cab2)->{
            double cab1Distance = DistanceCalculator.distance(cab1.getCurrentLocation(),from);
            double cab2Distance = DistanceCalculator.distance(cab2.getCurrentLocation(),from);
            return (int) (cab1Distance-cab2Distance);
        });

        cabList.stream().forEach(cab -> cabQueue.add(cab));
        Cab cab = cabQueue.poll();
        return cab;
    }
}
