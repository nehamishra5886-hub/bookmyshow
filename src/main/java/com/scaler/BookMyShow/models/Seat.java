package com.scaler.BookMyShow.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseEntity {

    private String seatNumber;

    private int rowNumber;
    private int columnNumber;
    private SeatType seatType;
    //private SeatStatus seatStatus;

}
