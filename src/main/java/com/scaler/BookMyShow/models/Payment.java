package com.scaler.BookMyShow.models;


import com.scaler.BookMyShow.models.enums.PaymentGateway;
import com.scaler.BookMyShow.models.enums.PaymentMode;
import com.scaler.BookMyShow.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends  BaseEntity {
    private double amount;

    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;
    //private String paymentStatus;
    //private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @Enumerated(value = EnumType.STRING)
    private PaymentGateway paymentGateway;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;


}
