package com.scaler.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseEntity {

    private Show show;

    private SeatType seatType;

    private double priceMultiplier;
}
