package moviebooking.controllers;

import moviebooking.services.ShowService;

import java.util.Date;

public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }
    public String addShow(String screenId, String movieId, Date startTime, long durationInSeconds){
        return showService.addNewShow(screenId,movieId,durationInSeconds,startTime);
    }
}
