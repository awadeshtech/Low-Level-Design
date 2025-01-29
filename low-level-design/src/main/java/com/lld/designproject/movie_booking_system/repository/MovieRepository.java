package com.lld.designproject.movie_booking_system.repository;

import com.lld.designproject.movie_booking_system.model.Movie;
import java.util.List;

public interface MovieRepository {
    void addMovie(Movie movie, String city);
    List<Movie> searchMovie(String searchString, String city);

}
