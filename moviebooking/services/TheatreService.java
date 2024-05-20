package moviebooking.services;

import moviebooking.models.Screen;
import moviebooking.models.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {
    private final Map<String, Theatre> theatreMap;
    public TheatreService() {
        this.theatreMap = new HashMap<>();
    }
    public String addNewTheatre(String name){
        Theatre theatre = new Theatre(UUID.randomUUID().toString(),name);
        theatreMap.put(theatre.getId(),theatre);
        return theatre.getId();
    }
    public Theatre getTheatre(String theatreId){
        Theatre theatre = theatreMap.getOrDefault(theatreId,null);
        return  theatre;
    }


}
