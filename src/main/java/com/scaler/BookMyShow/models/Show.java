package com.scaler.BookMyShow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends  BaseEntity{

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @Override
    public String toString() {
        return "Show{" +
                "movie=" + movie +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", screen=" + screen +
                '}';
    }
}
