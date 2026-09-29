package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.entity.Booking;
import com.example.movieticketbooking.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingRepository repository;

    public BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return repository.save(booking);
    }

    @PutMapping
    public Booking updateBooking(@RequestBody Booking booking) {
        return repository.save(booking);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable String id) {
        repository.deleteById(id);
        return "Booking deleted successfully";
    }

    // INNER JOIN
    @GetMapping("/innerjoin")
    public List<Object[]> innerJoin() {
        return repository.innerJoin();
    }

    // LEFT JOIN
    @GetMapping("/leftjoin")
    public List<Object[]> leftJoin() {
        return repository.leftJoin();
    }

    // RIGHT JOIN
    @GetMapping("/rightjoin")
    public List<Object[]> rightJoin() {
        return repository.rightJoin();
    }

    // FULL OUTER JOIN
    @GetMapping("/fullouterjoin")
    public List<Object[]> fullOuterJoin() {
        return repository.fullOuterJoin();
    }
}