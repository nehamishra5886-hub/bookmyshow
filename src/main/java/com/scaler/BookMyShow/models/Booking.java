package com.scaler.BookMyShow.models;

import com.scaler.BookMyShow.models.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseEntity{

    private String ticketNumber;
    private BookingStatus bookingStatus;

    private double amount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "booking_show_seat"
            //joinColumns = @JoinColumn(name = "booking_id"),
            //inverseJoinColumns = @JoinColumn(name = "show_seat_id")
    )
    private List<ShowSeat> bookedShowSeats;

    private String bookingTime;

    //private Movie movie;
    //private Screen screen;
    //private Date showTime;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;

}
