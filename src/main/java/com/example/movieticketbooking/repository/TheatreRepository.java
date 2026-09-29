package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, String> {

    @Query("""
        SELECT t.theatreName,
               t.city,
               s.screenName,
               s.capacity
        FROM Theatre t
        JOIN Screen s ON t.theatreId = s.theatreId
        """)
    List<Object[]> getTheatreScreenDetails();
}