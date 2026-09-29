package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.Show;
import com.example.movieticketbooking.entity.ShowId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, ShowId> {

    @Query("""
        SELECT m.movieName,
               s.screenName,
               t.theatreName,
               sh.showDate,
               sh.showTime
        FROM Show sh
        JOIN Movie m ON sh.movieId = m.movieId
        JOIN Screen s ON sh.screenId = s.screenId
        JOIN Theatre t ON s.theatreId = t.theatreId
        """)
    List<Object[]> getShowDetails();
}