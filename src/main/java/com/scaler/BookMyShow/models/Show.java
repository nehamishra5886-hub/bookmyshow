package com.scaler.BookMyShow.models;


import jakarta.persistence.*;
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

}
