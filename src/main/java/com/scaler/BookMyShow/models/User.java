package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseEntity {

    private String name;

    private String email;

    private String mobileNo;

    private String password;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private String role; // USER, ADMIN

    //private List<Ticket> tickets;
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
}
