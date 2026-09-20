package com.scaler.BookMyShow.dto;

import com.scaler.BookMyShow.models.Show;
import com.scaler.BookMyShow.models.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private String message;
    private String ticketId;
    private double amount;
    private ResponseStatus responseStatus;
    private Show show;

}
