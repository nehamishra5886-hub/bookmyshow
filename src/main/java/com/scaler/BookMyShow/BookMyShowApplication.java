package com.scaler.BookMyShow;

import com.scaler.BookMyShow.controller.BookingController;
import com.scaler.BookMyShow.controller.UserController;
import com.scaler.BookMyShow.controller.ViewShowsController;
import com.scaler.BookMyShow.dto.*;
import com.scaler.BookMyShow.models.Show;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class BookMyShowApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookMyShowApplication.class);
	@Autowired
	private UserController userController;
	//@Autowired
	//private UserService userService;


	@Autowired
	private ViewShowsController viewShowsController;

	@Autowired
	private BookingController bookingController;

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDto requestDto = new SignUpRequestDto();
		requestDto.setEmail("samara@gmail.com");
		requestDto.setPassword("1234");
		requestDto.setName("Samara");
		requestDto.setMobileNo("989755433");

		SignUpResponseDto responseDto = userController.signUp(requestDto);
		System.out.println("User ID: " + responseDto.getUserId());
		System.out.println("Sign up Response Status: " + responseDto.getResponseStatus());
		System.out.println("-----------------------------------");


		LoginRequestDto loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmail("samara@gmail.com");
		loginRequestDto.setPassword("1234");
		System.out.println(userController.login(loginRequestDto).getMessage());


		ViewShowsRequestDto viewShowsRequestDto = new ViewShowsRequestDto();
		viewShowsRequestDto.setMovieName("Kantara");
		viewShowsRequestDto.setRegionName("New York");

		ViewShowsResponseDto viewShowsResponseDto= viewShowsController.viewShowsByMovie(viewShowsRequestDto);

		Show show = viewShowsResponseDto.getShow();
		System.out.println("Shows for the movie: " + show.getMovie().getName()
				+ "\n in screen: " + show.getScreen().getName()
				+ "\n by " +show.getMovie().getDirector()
				+ "\n in " + show.getScreen().getTheatre().getName()
				+ "\n in theatre  " + show.getScreen().getTheatre().getName()
				+ "\n Starts at " + show.getStartTime());

		logger.info("Response Status: " + viewShowsResponseDto.getResponseStatus());

		BookTicketRequestDto bookTicketRequestDto = new BookTicketRequestDto();
		bookTicketRequestDto.setShowId(show.getId());
		bookTicketRequestDto.setUserId(1);
		bookTicketRequestDto.setSeatIds(new ArrayList<Integer>() {{
			add(1);
			add(2);
			//add(3);
			//add(4);
		}});
		BookTicketResponseDto bookTicketResponseDto= bookingController.bookTicket(bookTicketRequestDto);
		logger.info("Booking Response Status: " + bookTicketResponseDto.getResponseStatus());
		logger.info("Booking Message: " + bookTicketResponseDto.getMessage());
		logger.info("Booking Ticket ID: " + bookTicketResponseDto.getTicketId());
		logger.info("Booking Amount: " + bookTicketResponseDto.getAmount());
		System.out.println("bookTicketResponseDto "+bookTicketResponseDto.getShow());


	}
}
