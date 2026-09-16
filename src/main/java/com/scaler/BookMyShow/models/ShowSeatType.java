package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatType seatType;

    private double priceMultiplier;
}
