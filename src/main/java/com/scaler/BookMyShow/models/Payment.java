package com.scaler.BookMyShow.models;


import com.scaler.BookMyShow.models.enums.PaymentGateway;
import com.scaler.BookMyShow.models.enums.PaymentMode;
import com.scaler.BookMyShow.models.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends  BaseEntity {
    private double amount;

    private PaymentMode paymentMode;

    //private String paymentStatus;

    private Ticket ticket;

    private PaymentGateway paymentGateway;

    private PaymentStatus paymentStatus;


}
