package com.scaler.BookMyShow.models;

import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class Ticket extends BaseEntity {

    private String ticketNumber;


    @ManyToMany
    //@JoinTable
    private List<ShowSeat> bookedShowSeats;

    private User user;


    private double price;

    private String bookingTime;

    private Movie movie;

    private Screen screen;

    private Date showTime;

    private Show show;

    private List<Payment> payments;



}
