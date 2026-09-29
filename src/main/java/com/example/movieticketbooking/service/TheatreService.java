package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.Theatre;
import com.example.movieticketbooking.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatreRepository repository;

    public TheatreService(TheatreRepository repository) {
        this.repository = repository;
    }

    public List<Theatre> getAllTheatres() {
        return repository.findAll();
    }

    public Theatre getTheatre(String id) {
        return repository.findById(id).orElse(null);
    }

    public Theatre addTheatre(Theatre theatre) {
        return repository.save(theatre);
    }

    public Theatre updateTheatre(Theatre theatre) {
        return repository.save(theatre);
    }

    public void deleteTheatre(String id) {
        repository.deleteById(id);
    }

    public List<Object[]> getTheatreScreenDetails() {
        return repository.getTheatreScreenDetails();
    }
}