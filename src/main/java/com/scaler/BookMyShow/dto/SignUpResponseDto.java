package com.scaler.BookMyShow.dto;


import com.scaler.BookMyShow.models.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private long userId;
    private ResponseStatus responseStatus;
}
