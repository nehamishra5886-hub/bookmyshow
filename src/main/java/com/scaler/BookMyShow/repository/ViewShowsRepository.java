package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.Movie;
import com.scaler.BookMyShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViewShowsRepository extends JpaRepository<Show, Integer> {

    Optional<List<Show>> findByMovie(Movie movie);

    //Optional<Show> findByTheatre(String theatreName);

}
