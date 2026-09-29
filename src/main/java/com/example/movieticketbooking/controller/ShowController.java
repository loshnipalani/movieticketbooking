package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.entity.Show;
import com.example.movieticketbooking.entity.ShowId;
import com.example.movieticketbooking.repository.ShowRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowRepository repository;

    public ShowController(ShowRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Show> getAllShows() {
        return repository.findAll();
    }

    @PostMapping
    public Show addShow(@RequestBody Show show) {
        return repository.save(show);
    }

    @PutMapping
    public Show updateShow(@RequestBody Show show) {
        return repository.save(show);
    }

    @DeleteMapping
    public String deleteShow(@RequestBody ShowId showId) {
        repository.deleteById(showId);
        return "Show deleted successfully";
    }

    @GetMapping("/details")
    public List<Object[]> getShowDetails() {
        return repository.getShowDetails();
    }
}
