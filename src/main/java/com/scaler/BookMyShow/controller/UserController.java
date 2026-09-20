package com.scaler.BookMyShow.controller;


import com.scaler.BookMyShow.dto.LoginRequestDto;
import com.scaler.BookMyShow.dto.LoginResponseDto;
import com.scaler.BookMyShow.dto.SignUpRequestDto;
import com.scaler.BookMyShow.dto.SignUpResponseDto;
import com.scaler.BookMyShow.models.User;
import com.scaler.BookMyShow.models.enums.ResponseStatus;
import com.scaler.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto request) {
        SignUpResponseDto response = new SignUpResponseDto();
        try {
            User savedUser = userService.signUp(request);
            response.setUserId(savedUser.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }

    public LoginResponseDto login(LoginRequestDto request) {
        LoginResponseDto response = new LoginResponseDto();
        try {
            String loginMessage = userService.login(request.getEmail(), request.getPassword());
            response.setMessage(loginMessage);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setMessage("Login failed: " + e.getMessage());
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
