package com.scaler.BookMyShow.dto;

import com.scaler.BookMyShow.models.Show;
import com.scaler.BookMyShow.models.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewShowsResponseDto {
//    private String movieName;
//    private String cityName;
//    private String date;
//    private String showTime;
//    private String theaterName;
//    private String screenName;
//    private int availableSeats;

    private Show show;
    //private List<Theatre> theatres;
    private ResponseStatus responseStatus;
}
