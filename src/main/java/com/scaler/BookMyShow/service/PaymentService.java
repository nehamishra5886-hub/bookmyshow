package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.models.Booking;
import com.scaler.BookMyShow.models.ShowSeat;
import com.scaler.BookMyShow.models.enums.BookingStatus;
import com.scaler.BookMyShow.models.enums.SeatStatus;
import com.scaler.BookMyShow.repository.BookingRepository;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    private final BookingRepository bookingRepository;
    private final ShowSeatRepository showSeatRepository;

    public PaymentService(
            BookingRepository bookingRepository,
            ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }


    @Transactional
    public void processPayment(int bookingId, boolean paymentSuccess) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Don't process an already completed/expired booking
        if (booking.getBookingStatus() != BookingStatus.PENDING) {
            return;
        }

        if (paymentSuccess) {

            // Payment successful -> confirm booking
            booking.setBookingStatus(BookingStatus.CONFIRMED);
            bookingRepository.save(booking);

        } else {

            // Payment failed -> release seats
            releaseSeats(booking);

            booking.setBookingStatus(BookingStatus.FAILED);
            bookingRepository.save(booking);
        }
    }
    private void releaseSeats(Booking booking) {

        for (ShowSeat showSeat : booking.getBookedShowSeats()) {
            showSeat.setStatus(SeatStatus.AVAILABLE);
            showSeatRepository.save(showSeat);
        }
    }

}
