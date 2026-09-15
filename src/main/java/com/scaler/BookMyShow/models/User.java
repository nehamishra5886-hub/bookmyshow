package com.scaler.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends BaseEntity {

    private String name;

    private String email;

    private String phoneNumber;

    private String password;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private String role; // USER, ADMIN

    private List<Ticket> tickets;
}
