package cabbooking.Services;

import cabbooking.exceptions.CarNotFoundException;
import cabbooking.models.Cab;
import cabbooking.models.CarStatus;
import cabbooking.models.Driver;
import cabbooking.models.Location;
import cabbooking.providers.DistanceCalculator;

import java.util.*;

public class CabService {
    private final DriverService driverService;
    private final Map<String, Cab> cabMap;

    public CabService(DriverService driverService) {
        this.driverService = driverService;
        this.cabMap = new HashMap<>();
    }

    public String addCab(String name, String driverId){
        Driver driver = driverService.getDriver(driverId);
        Cab cab = new Cab(UUID.randomUUID().toString(),name,driver);
        cabMap.put(cab.getId(),cab);
        return cab.getId();
    }
    public Cab getcab(String cabId){
        Cab cab = cabMap.getOrDefault(cabId,null);
        if(cab==null){
            throw new CarNotFoundException();
        }
        return cab;
    }
    public List<Cab> getAvailableCabs(String city){
        return cabMap.values().stream()
                .filter((cab)->{
                    return cab.getDriver().getCity().equals(city) && cab.getCarStatus().equals(CarStatus.Available) && cab.getDriver().isAvailable();})
                .toList();
    }

    public List<Cab> getAvailableCabsForLocationWithInMetres(Location location, Integer metres, String city){
        return getAvailableCabs(city).stream()
                .filter((cab)->{
                    return DistanceCalculator.distance(location,cab.getCurrentLocation())<=metres;
                }).toList();
    }
}
