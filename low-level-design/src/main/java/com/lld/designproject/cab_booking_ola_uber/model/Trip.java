package com.lld.designproject.cab_booking_ola_uber.model;

import com.lld.designproject.cab_booking_ola_uber.model.constants.TripStatus;
import lombok.NonNull;
import lombok.ToString;

@ToString
public class Trip {
    private String id;
    private TripStatus tripStatus;
    private Rider rider;
    private Cab cab;

    private Location fromPoint;
    private Location toPoint;
    private Double price;

    public Trip(@NonNull String id, @NonNull Rider rider, @NonNull Cab cab, @NonNull Location fromPoint,
                @NonNull Location toPoint, @NonNull Double price) {
        this.id = id;
        this.rider = rider;
        this.cab = cab;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.price = price;
        this.tripStatus = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.tripStatus = TripStatus.FINISHED;
    }
}
