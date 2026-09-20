package com.scaler.BookMyShow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseEntity {

    private String seatNumber;

    private int rowVal;
    private int colVal;
    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatType seatType;
    //private SeatStatus seatStatus;


    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", rowVal=" + rowVal +
                ", colVal=" + colVal +
                ", seatType=" + seatType +
                '}';
    }
}
