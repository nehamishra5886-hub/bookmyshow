package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.models.*;
import com.scaler.BookMyShow.models.enums.BookingStatus;
import com.scaler.BookMyShow.models.enums.SeatStatus;
import com.scaler.BookMyShow.repository.BookingRepository;
import com.scaler.BookMyShow.repository.ShowRepository;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import com.scaler.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.*;



@Service
public class BookingService {

    private final UserRepository userRepository;

    private final ShowRepository showRepository;

    private ShowSeatRepository showSeatRepository;

    private BookingRepository bookingRepository;

    private PriceCalculator priceCalculator;



    @Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository,
                          BookingRepository bookingRepository, PriceCalculator priceCalculator, ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculator = priceCalculator;


    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(int userId, int showId, List<Integer> showSeatIds) {
        // Logic to bookedBy the ticket

//        Optional<User> userOptional = userRepository.findById((int) userId);
//        if(userOptional.isEmpty()) {
//            throw new RuntimeException("User not found");
//        }
//
//        User user = userOptional.get();

        User bookedBy  = userRepository.findById( userId)
                .orElseThrow(() -> new RuntimeException("User not found "+userId));
        Show bookedShow = showRepository.findById( showId)
                .orElseThrow(() -> new RuntimeException("Show not found "+showId));

        if(showSeatIds.size() > 10 ) {
            throw new RuntimeException("Cannot book more than 10 seats at a time");
        }

        List<ShowSeat> bookedSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat : bookedSeats) {
            boolean isAvailable = showSeat.getStatus().equals(SeatStatus.AVAILABLE);
            boolean isExpired = showSeat.getStatus().equals(SeatStatus.BLOCKED) &&
                    Duration.between(new Date().toInstant(), showSeat.getBlockedAt().toInstant()).toMinutesPart() > 15;


            if (!isAvailable && !isExpired) {
                throw new RuntimeException("Seat " + showSeat.getId() + " is already booked");
            }
        }

        //SOFT BLOCK
        List<ShowSeat> savedShowSeats =new ArrayList<>();
        for (ShowSeat showSeat : bookedSeats) {
            showSeat.setStatus(SeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        Booking booking = new Booking();
        booking.setTicketNumber(String.valueOf(UUID.randomUUID()));
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculator.calculatePrice(bookedShow, savedShowSeats));
        booking.setUser(bookedBy);
        booking.setBookedShowSeats(savedShowSeats);
        booking.setShow(bookedShow);
        booking.setPayments(new ArrayList<>());

        Booking savedBooking = bookingRepository.save(booking);
        return savedBooking;
        //return bookingRepository.save(booking);
    }
}
