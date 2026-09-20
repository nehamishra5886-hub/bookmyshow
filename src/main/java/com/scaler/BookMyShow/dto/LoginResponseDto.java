package com.scaler.BookMyShow.dto;


import com.scaler.BookMyShow.models.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private long userId;
    private String name;
    private ResponseStatus responseStatus;
    private String message;

}
