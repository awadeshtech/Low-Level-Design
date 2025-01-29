package com.lld.designproject.movie_booking_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Seat {
    Integer seatNumber;
    SeatType seatType;
}
