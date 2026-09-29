package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.entity.Theatre;
import com.example.movieticketbooking.service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private final TheatreService service;

    public TheatreController(TheatreService service) {
        this.service = service;
    }

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return service.getAllTheatres();
    }

    @GetMapping("/{id}")
    public Theatre getTheatre(@PathVariable String id) {
        return service.getTheatre(id);
    }

    @PostMapping
    public Theatre addTheatre(@RequestBody Theatre theatre) {
        return service.addTheatre(theatre);
    }

    @PutMapping
    public Theatre updateTheatre(@RequestBody Theatre theatre) {
        return service.updateTheatre(theatre);
    }

    @DeleteMapping("/{id}")
    public String deleteTheatre(@PathVariable String id) {
        service.deleteTheatre(id);
        return "Theatre deleted successfully";
    }

    @GetMapping("/details")
    public List<Object[]> getTheatreScreenDetails() {
        return service.getTheatreScreenDetails();
    }
}