package com.lld.designproject.movie_booking_system.repository;

import com.lld.designproject.movie_booking_system.model.Show;
import java.util.List;

public interface ShowRepository {
    List<Show> searchShows(String movieName);
}
