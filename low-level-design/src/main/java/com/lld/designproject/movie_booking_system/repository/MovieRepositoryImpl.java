package com.lld.designproject.movie_booking_system.repository;

import com.lld.designproject.movie_booking_system.model.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MovieRepositoryImpl implements MovieRepository {

    List<Movie> movies;
    Map<String, List<Movie>> cityToMovieMap;

    public MovieRepositoryImpl() {
        this.movies = Collections.synchronizedList(new ArrayList<>());
        cityToMovieMap = new HashMap<>();
    }


    @Override
    public void addMovie(Movie movie, String city) {
        movies.add(movie);
        if (!cityToMovieMap.containsKey(city)) {
            cityToMovieMap.put(city, new ArrayList<>());
        }
        cityToMovieMap.get(city).add(movie);
    }

    @Override
    public List<Movie> searchMovie(String searchString, String city) {
        return cityToMovieMap.get(city).stream().filter(movie -> movie.getName().startsWith(searchString))
            .collect(Collectors.toList());
    }
}
