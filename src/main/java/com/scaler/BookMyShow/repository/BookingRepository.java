package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.Booking;
import com.scaler.BookMyShow.models.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByBookingStatus(BookingStatus status);

}
