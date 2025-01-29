package com.lld.designproject.movie_booking_system.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Theatre {
    String id;
    Location location;
    List<Screen> screens;
    List<Show> shows;
}
