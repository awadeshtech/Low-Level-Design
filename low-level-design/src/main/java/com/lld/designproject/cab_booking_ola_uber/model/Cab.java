package com.lld.designproject.cab_booking_ola_uber.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cab {
    int id;
    String regNo;
    String driverName;
    @Setter
    Trip currentTrip;
    @Setter
    Location currentLocation;
    @Setter
    Boolean isAvailable;
}
