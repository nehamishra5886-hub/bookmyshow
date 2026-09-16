package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.models.Booking;
import com.scaler.BookMyShow.models.Show;
import com.scaler.BookMyShow.models.User;
import com.scaler.BookMyShow.repository.ShowRepository;
import com.scaler.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TicketService {

    private final UserRepository userRepository;

    private final ShowRepository showRepository;


    @Autowired
    public TicketService(UserRepository userRepository, ShowRepository showRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    public Booking bookTicket(int userId, int showId, List<Integer> showSeatIds) {
        // Logic to book the ticket

//        Optional<User> userOptional = userRepository.findById((int) userId);
//        if(userOptional.isEmpty()) {
//            throw new RuntimeException("User not found");
//        }
//
//        User user = userOptional.get();

        User user  = userRepository.findById( userId).orElseThrow(() -> new RuntimeException("User not found "+userId));
        Show show = showRepository.findById( showId).orElseThrow(() -> new RuntimeException("Show not found "+showId));

        return null;
    }
}
