package com.lld.designproject.movie_booking_system.model;

import java.time.ZonedDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Show {
    String showId;
    ZonedDateTime startTime;
    Long duration;
    Movie movie;
    Screen screen;
    List<Integer> bookingSeatIds;
}
