package com.scaler.BookMyShow.models;

import com.scaler.BookMyShow.models.enums.Feature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie extends  BaseEntity{
    private String name;
    @ElementCollection
    private List<String> cast;
    private String director;
    @ElementCollection
    private List<Feature> features;
    private String description;
    private int durationInMinutes;
    private String language;
    private String genre;

    @ElementCollection
    private List<ShowSeat> showSeats;

}
