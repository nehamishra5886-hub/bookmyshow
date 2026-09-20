package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.models.SeatType;
import com.scaler.BookMyShow.models.ShowSeatType;
import com.scaler.BookMyShow.models.Show;
import com.scaler.BookMyShow.models.ShowSeat;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PriceCalculator {

    private ShowSeatRepository showSeatTypeRepository;

    public double calculatePrice(Show show, List<ShowSeat> showSeats) {
        return 100.0;
    }

}
