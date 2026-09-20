package com.scaler.BookMyShow;

import com.scaler.BookMyShow.controller.UserController;
import com.scaler.BookMyShow.dto.SignUpRequestDto;
import com.scaler.BookMyShow.dto.SignUpResponseDto;
import com.scaler.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDto requestDto = new SignUpRequestDto();
		requestDto.setEmail("acv@gmail.com");
		requestDto.setPassword("1234");
		requestDto.setName("abc");
		requestDto.setMobileNo("1234567890");

		SignUpResponseDto responseDto = userController.signUp(requestDto);
		System.out.println("User ID: " + responseDto.getUserId());
		System.out.println("Sign up Response Status: " + responseDto.getResponseStatus());
		System.out.println("-----------------------------------");


		System.out.println(userService.login("samara@gmail.com","1234"));

	}
}
