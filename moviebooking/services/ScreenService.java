package moviebooking.services;

import moviebooking.models.Screen;
import moviebooking.models.Seat;
import moviebooking.models.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScreenService {
    private  final TheatreService theatreService;
    private final Map<String,Screen> screenMap;
    public ScreenService(TheatreService theatreService) {
        this.theatreService = theatreService;
        screenMap = new HashMap<>();
    }

    public String addNewScreen(String name,String theatreId){
        Theatre theatre = theatreService.getTheatre(theatreId);
        Screen screen = new Screen(UUID.randomUUID().toString(),name,theatre);
        theatre.addScreen(screen);
        return screen.getId();
    }

    public Screen getScreen(String screenId){
        Screen screen = screenMap.getOrDefault(screenId,null);
        return screen;
    }
    public void addSeat(Seat seat,String screenId){
        Screen screen = getScreen(screenId);
        screen.addSeat(seat);
    }

}
