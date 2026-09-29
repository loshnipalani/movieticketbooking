package com.example.movieticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movie_show")
@IdClass(ShowId.class)
public class Show {

    @Id
    private String screenId;

    @Id
    private String movieId;

    @Id
    private LocalDate showDate;

    @Id
    private LocalTime showTime;

    public Show() {
    }

    public Show(String screenId, String movieId,
                LocalDate showDate, LocalTime showTime) {

        this.screenId = screenId;
        this.movieId = movieId;
        this.showDate = showDate;
        this.showTime = showTime;
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

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }
}
