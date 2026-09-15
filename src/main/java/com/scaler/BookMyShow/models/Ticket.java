package com.scaler.BookMyShow.models;

import com.scaler.BookMyShow.models.enums.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class Ticket extends BaseEntity {

    private String ticketNumber;


    private List<ShowSeat> showSeats;

    private User user;

    private ShowSeat showSeat;

    private double price;

    private String bookingTime;

    private Movie movie;

    private Screen screen;

    private Date showTime;

    //private Status status;

    private List<Payment> payments;



}
