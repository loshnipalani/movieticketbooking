package com.example.movieticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    private String bookingId;

    private String customerId;
    private String screenId;
    private String movieId;
    private String seatNo;
    private LocalDate bookingDate;

    public Booking() {
    }

    public Booking(String bookingId, String customerId,
                   String screenId, String movieId,
                   String seatNo, LocalDate bookingDate) {

        this.bookingId = bookingId;
        this.customerId = customerId;
        this.screenId = screenId;
        this.movieId = movieId;
        this.seatNo = seatNo;
        this.bookingDate = bookingDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
