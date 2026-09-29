package com.example.movieticketbooking.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class ShowId implements Serializable {

    private String screenId;
    private String movieId;
    private LocalDate showDate;
    private LocalTime showTime;

    public ShowId() {
    }

    public ShowId(String screenId, String movieId,
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

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShowId showId = (ShowId) o;

        return Objects.equals(screenId, showId.screenId)
                && Objects.equals(movieId, showId.movieId)
                && Objects.equals(showDate, showId.showDate)
                && Objects.equals(showTime, showId.showTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screenId, movieId, showDate, showTime);
    }
}