package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, String> {

    @Query("""
        SELECT s.screenName,
               s.capacity,
               t.theatreName,
               t.city
        FROM Screen s
        JOIN Theatre t ON s.theatreId = t.theatreId
        """)
    List<Object[]> getScreenTheatreDetails();
}