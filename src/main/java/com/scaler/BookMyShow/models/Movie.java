package com.scaler.BookMyShow.models;

import com.scaler.BookMyShow.models.enums.Feature;
import com.scaler.BookMyShow.models.enums.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends  BaseEntity{
    private String name;
    private List<String> cast;
    private String director;
    private List<Feature> features;
    private String description;
    private int durationInMinutes;
    private String language;
    private String genre;

    private List<ShowSeat> showSeats;

}
