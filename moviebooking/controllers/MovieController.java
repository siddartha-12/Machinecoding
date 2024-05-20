package moviebooking.controllers;

import moviebooking.services.MovieService;

public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String addNewMovie(String name){
        return movieService.addNewMovie(name);
    }
}
