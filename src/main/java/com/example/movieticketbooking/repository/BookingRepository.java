package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, String> {

    // INNER JOIN
    @Query(value = """
        SELECT b.booking_id,
               c.customer_name,
               m.movie_name,
               s.screen_name,
               t.theatre_name,
               b.seat_no,
               b.booking_date
        FROM booking b
        INNER JOIN customer c
            ON b.customer_id = c.customer_id
        INNER JOIN movie m
            ON b.movie_id = m.movie_id
        INNER JOIN screen s
            ON b.screen_id = s.screen_id
        INNER JOIN theatre t
            ON s.theatre_id = t.theatre_id
        """, nativeQuery = true)
    List<Object[]> innerJoin();


    // LEFT JOIN
    @Query(value = """
        SELECT b.booking_id,
               c.customer_name,
               m.movie_name,
               s.screen_name,
               t.theatre_name,
               b.seat_no,
               b.booking_date
        FROM booking b
        LEFT JOIN customer c
            ON b.customer_id = c.customer_id
        LEFT JOIN movie m
            ON b.movie_id = m.movie_id
        LEFT JOIN screen s
            ON b.screen_id = s.screen_id
        LEFT JOIN theatre t
            ON s.theatre_id = t.theatre_id
        """, nativeQuery = true)
    List<Object[]> leftJoin();


    // RIGHT JOIN
    @Query(value = """
        SELECT b.booking_id,
               c.customer_name,
               m.movie_name,
               s.screen_name,
               t.theatre_name,
               b.seat_no,
               b.booking_date
        FROM booking b
        RIGHT JOIN customer c
            ON b.customer_id = c.customer_id
        RIGHT JOIN movie m
            ON b.movie_id = m.movie_id
        RIGHT JOIN screen s
            ON b.screen_id = s.screen_id
        RIGHT JOIN theatre t
            ON s.theatre_id = t.theatre_id
        """, nativeQuery = true)
    List<Object[]> rightJoin();


    // FULL OUTER JOIN
    // MySQL does not directly support FULL OUTER JOIN.
    // So we use LEFT JOIN UNION RIGHT JOIN.
    @Query(value = """
        SELECT b.booking_id,
               c.customer_name,
               m.movie_name,
               s.screen_name,
               t.theatre_name,
               b.seat_no,
               b.booking_date
        FROM booking b
        LEFT JOIN customer c
            ON b.customer_id = c.customer_id
        LEFT JOIN movie m
            ON b.movie_id = m.movie_id
        LEFT JOIN screen s
            ON b.screen_id = s.screen_id
        LEFT JOIN theatre t
            ON s.theatre_id = t.theatre_id

        UNION

        SELECT b.booking_id,
               c.customer_name,
               m.movie_name,
               s.screen_name,
               t.theatre_name,
               b.seat_no,
               b.booking_date
        FROM booking b
        RIGHT JOIN customer c
            ON b.customer_id = c.customer_id
        RIGHT JOIN movie m
            ON b.movie_id = m.movie_id
        RIGHT JOIN screen s
            ON b.screen_id = s.screen_id
        RIGHT JOIN theatre t
            ON s.theatre_id = t.theatre_id
        """, nativeQuery = true)
    List<Object[]> fullOuterJoin();
}