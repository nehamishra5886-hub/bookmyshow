package com.scaler.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class BaseEntity {
    private int id;
    private Date createdAt;
    private Date updatedAt;
}
