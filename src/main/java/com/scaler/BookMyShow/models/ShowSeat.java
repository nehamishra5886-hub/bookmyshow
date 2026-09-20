package com.scaler.BookMyShow.models;

import com.scaler.BookMyShow.models.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
public class ShowSeat extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Enumerated(value = EnumType.STRING) //stores enums as string , default - ordinal
    private SeatStatus status;

    private Date blockedAt; //when the seat was blocked for booking

}
