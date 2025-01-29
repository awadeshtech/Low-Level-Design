package com.lld.designproject.movie_booking_system.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Screen {
    String id;
    String code;
    List<Seat> seatList;
}
