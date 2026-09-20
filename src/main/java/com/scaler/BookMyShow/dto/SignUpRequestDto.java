package com.scaler.BookMyShow.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    String email;
    String password;
    String name;
    String mobileNo;
}
