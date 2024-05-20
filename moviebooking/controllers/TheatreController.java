package moviebooking.controllers;

import moviebooking.services.TheatreService;

public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String addNewTheatre(String name){
        return theatreService.addNewTheatre(name);
    }
}
