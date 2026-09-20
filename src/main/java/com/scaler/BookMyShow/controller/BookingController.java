package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.dto.BookTicketRequestDto;
import com.scaler.BookMyShow.dto.BookTicketResponseDto;
import com.scaler.BookMyShow.models.Booking;
import com.scaler.BookMyShow.models.enums.ResponseStatus;
import com.scaler.BookMyShow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
        BookTicketResponseDto response = new BookTicketResponseDto();

        try {
            // Call the service layer to book the ticket
            Booking booking = bookingService.bookTicket(request.getUserId(),
                    request.getShowId(), request.getSeatIds());

            response.setMessage("Ticket booked successfully");
            response.setTicketId(booking.getTicketNumber()); // This should be replaced with the actual ticket ID from the booking
            response.setAmount(booking.getAmount()); // Assuming Booking has a method to get the total amount
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setMessage("Failed to book ticket: " + e.getMessage());
            response.setResponseStatus(ResponseStatus.FAILURE);
        }


        return response;
    }
}
