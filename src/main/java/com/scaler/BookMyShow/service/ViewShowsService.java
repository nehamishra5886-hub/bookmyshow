package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.dto.ViewShowsRequestDto;
import com.scaler.BookMyShow.models.Movie;
import com.scaler.BookMyShow.models.Show;
import com.scaler.BookMyShow.repository.MovieRepository;
import com.scaler.BookMyShow.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewShowsService {


    //public ViewShowsRepository viewShowsRepository;

    public MovieRepository movieRepository;

    public ShowRepository showRepository;

    @Autowired
    public ViewShowsService(MovieRepository movieRepository,
                            ShowRepository showRepository) {
        //this.viewShowsRepository = viewShowsRepository;
        this.movieRepository = movieRepository;
        this.showRepository = showRepository;
    }

    public Show viewShowsByMovie(ViewShowsRequestDto request) {
        Movie movieName = movieRepository.findByName(request.getMovieName())
                .orElseThrow(() -> new RuntimeException("Movie not found"+" "+request.getMovieName()));
        return showRepository.findByMovie(movieName)
                .orElseThrow(() -> new RuntimeException("No shows found for the movie"));

    }

    public Show viewShowsByTheaterName() {
        return null;
    }

    public Show viewShowsByLocation() {
        return null;
    }

    public Show viewShowsByDate() {
        return null;
    }
}
