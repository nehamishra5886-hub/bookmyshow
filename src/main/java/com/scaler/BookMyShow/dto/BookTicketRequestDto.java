package com.scaler.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private int showId;
    private int userId;
    private List<Integer> seatIds;





}
