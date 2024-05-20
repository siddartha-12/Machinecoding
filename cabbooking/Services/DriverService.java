package cabbooking.Services;

import cabbooking.exceptions.DriverNotFoundException;
import cabbooking.models.Driver;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DriverService {
    private final Map<String, Driver> driverMap;

    public DriverService() {
        this.driverMap = new HashMap<>();
    }

    public String addNewDriver(String name, String city){
        Driver driver = new Driver(UUID.randomUUID().toString(),name,city);
        driverMap.put(driver.getId(),driver);
        return driver.getId();
    }
    public Driver getDriver(String id){
        Driver driver = driverMap.getOrDefault(id,null);
        if (driver==null){
            throw new DriverNotFoundException();
        }
        return driver;
    }
}
