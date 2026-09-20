package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.dto.ViewShowsRequestDto;
import com.scaler.BookMyShow.dto.ViewShowsResponseDto;
import com.scaler.BookMyShow.models.Show;
import com.scaler.BookMyShow.models.enums.ResponseStatus;
import com.scaler.BookMyShow.service.ViewShowsService;
import org.springframework.stereotype.Controller;


@Controller
public class ViewShowsController {

    private ViewShowsService viewShowsService;

    public ViewShowsController(ViewShowsService viewShowsService) {
        this.viewShowsService = viewShowsService;
    }

    public ViewShowsResponseDto viewShowsByMovie(ViewShowsRequestDto request) {
        ViewShowsResponseDto response = new ViewShowsResponseDto();
        // Implement the logic to handle the request and call the service method
        if (request.getMovieName() == null ) {
            throw new IllegalArgumentException("Movie name cannot be null or empty");
        }
        String movieName = request.getMovieName();
        try {
            Show shows = viewShowsService.viewShowsByMovie(request);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setShow(shows);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching shows: " + e.getMessage());
        }

    }

}
