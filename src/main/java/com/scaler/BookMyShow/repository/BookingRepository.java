package com.scaler.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository<Booking> extends JpaRepository<Booking, Integer> {

}
