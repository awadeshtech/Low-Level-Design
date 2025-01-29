package com.lld.designproject.movie_booking_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String locationId;
    private String locationCode;
    private String city;
    private double lattitude;
    private double longitude;
}
