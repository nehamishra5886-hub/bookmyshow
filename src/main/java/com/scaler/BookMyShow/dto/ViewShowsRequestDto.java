package com.scaler.BookMyShow.dto;


import com.scaler.BookMyShow.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewShowsRequestDto {
    private String movieName;
    private String regionName;
    //private String date;
}
