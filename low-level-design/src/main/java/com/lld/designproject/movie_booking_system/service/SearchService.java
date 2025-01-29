package com.lld.designproject.movie_booking_system.service;

import com.lld.designproject.movie_booking_system.model.Movie;
import com.lld.designproject.movie_booking_system.model.Show;
import java.util.List;

public interface SearchService {
    List<Movie> searchMovie(String searchString);
    List<Show> searchShow(String movieId);
}
