package com.example.movieticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre")
public class Theatre {

    @Id
    private String theatreId;

    private String theatreName;
    private String city;

    public Theatre() {
    }

    public Theatre(String theatreId, String theatreName, String city) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}