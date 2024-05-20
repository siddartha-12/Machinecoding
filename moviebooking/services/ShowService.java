package moviebooking.services;

import moviebooking.models.*;

import java.util.*;
import java.util.stream.Collectors;

public class ShowService {
    private final Map<String, Show> showMap;
    private final MovieService movieService;
    private final ScreenService screenService;

    public ShowService(MovieService movieService, ScreenService screenService) {
        this.movieService = movieService;
        this.screenService = screenService;
        this.showMap = new HashMap<>();
    }

    public String addNewShow(String screenId, String movieId, Long durationInSeconds, Date startTime){
        Movie movie = movieService.getMovie(movieId);
        Screen screen = screenService.getScreen(screenId);
        Show show = new Show(UUID.randomUUID().toString(),screen,movie,startTime,durationInSeconds);
        showMap.put(show.getId(),show);
        return show.getId();
    }

    public Show getShow(String showId){
        Show show = showMap.getOrDefault(showId,null);
        return show;
    }
    public List<Show> getShowsInTheatre(String theatreId){
        List<Show> shows = showMap.values().stream()
                .filter((show)->{
                    return show.getScreen().getTheatre().getId().equals(theatreId);
                })
                .collect(Collectors.toList());
        return shows;
    }

}
