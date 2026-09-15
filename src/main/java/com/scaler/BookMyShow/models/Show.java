package com.scaler.BookMyShow.models;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Show extends  BaseEntity{

    private Movie movie;

    private Date startTime;

    private Date endTime;

    private Screen screen;

}
