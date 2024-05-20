package moviebooking.controllers;

import moviebooking.models.Seat;
import moviebooking.services.ScreenService;

public class ScreenController {
    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    public String addNewScreen(String name,String theaterId){
        return screenService.addNewScreen(name,theaterId);
    }

    public void addNewSeat(String screenId, Seat seat){
        screenService.addSeat(seat,screenId);
    }
}
