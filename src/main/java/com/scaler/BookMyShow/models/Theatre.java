package com.scaler.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theatre extends  BaseEntity{
    private String name;
    private Region region;

    private List<Screen> screens;



}
