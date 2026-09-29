package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = """
        SELECT c.customer_name,
               c.phone,
               m.movie_name,
               b.seat_no,
               b.booking_date
        FROM booking b
        INNER JOIN customer c
            ON b.customer_id = c.customer_id
        INNER JOIN movie m
            ON b.movie_id = m.movie_id
        """, nativeQuery = true)
    List<Object[]> getCustomerBookingDetails();
}