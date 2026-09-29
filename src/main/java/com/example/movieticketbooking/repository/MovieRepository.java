package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

    @Query("""
        SELECT m.movieName,
               s.screenName,
               t.theatreName
        FROM Movie m
        JOIN Show sh ON m.movieId = sh.movieId
        JOIN Screen s ON sh.screenId = s.screenId
        JOIN Theatre t ON s.theatreId = t.theatreId
        """)
    List<Object[]> getMovieScreenTheatre();
}