package cabbooking.Services;


import cabbooking.models.Rider;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RiderService {
    private final Map<String, Rider> riderMap;

    public RiderService() {
        this.riderMap = new HashMap<>();
    }
    public String addRider(String city, String name){
       Rider rider = new Rider(city,UUID.randomUUID().toString(),name);
       riderMap.put(rider.getId(),rider);
       return rider.getId();
    }
    public Rider getRider(String id){
        return riderMap.getOrDefault(id,null);
    }
}
