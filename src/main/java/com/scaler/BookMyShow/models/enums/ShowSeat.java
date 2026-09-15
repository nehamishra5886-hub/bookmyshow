package com.scaler.BookMyShow.models.enums;

import com.scaler.BookMyShow.models.BaseEntity;
import com.scaler.BookMyShow.models.Seat;
import com.scaler.BookMyShow.models.SeatStatus;
import com.scaler.BookMyShow.models.Show;

public class ShowSeat extends BaseEntity {
    private Show show;

    private Seat seat;

    private SeatStatus status;

}
