package moviebooking.services;


import moviebooking.models.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {
    private final Map<String, Movie> movieMap;

    public MovieService() {
        movieMap = new HashMap<>();
    }
    public String addNewMovie(String name){
        Movie movie = new Movie(UUID.randomUUID().toString(),name);
        movieMap.put(movie.getId(),movie);
        return movie.getId();
    }
    public Movie getMovie(String movieId){
        Movie movie = movieMap.getOrDefault(movieId,null);
        return movie;
    }
}
