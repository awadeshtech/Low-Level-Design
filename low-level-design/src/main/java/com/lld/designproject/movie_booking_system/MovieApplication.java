package com.lld.designproject.movie_booking_system;


import com.lld.designproject.movie_booking_system.model.Location;
import com.lld.designproject.movie_booking_system.model.Movie;
import com.lld.designproject.movie_booking_system.model.Screen;
import com.lld.designproject.movie_booking_system.model.Seat;
import com.lld.designproject.movie_booking_system.model.SeatType;
import com.lld.designproject.movie_booking_system.model.Theatre;
import com.lld.designproject.movie_booking_system.repository.MovieRepository;
import com.lld.designproject.movie_booking_system.repository.MovieRepositoryImpl;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
     // objects - Movie, Show, screen , theatre, city, screen will have seats, bookings
     // flow - search movie, get shows from all the theatres, book ticket for a show

        Movie movie = new Movie("1","DDLJ");
        MovieRepository movieRepository = new MovieRepositoryImpl();
        movieRepository.addMovie(movie, "Delhi");

        Location location = new Location();
        location.setCity("Delhi");
        location.setLocationId("1");

        List<Seat> seats = new ArrayList<>();
        Seat seat1 = new Seat(1, SeatType.PREMIUM);
        Seat seat2 = new Seat(2, SeatType.STANDARD);
        seats.add(seat1);
        seats.add(seat2);

        Screen screen = new Screen("1","ABC", seats);
        Theatre theatre = new Theatre("1",location,new ArrayList<>(),new ArrayList<>());

    }
}
