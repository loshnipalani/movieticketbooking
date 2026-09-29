package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.entity.Movie;
import com.example.movieticketbooking.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return repository.save(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) {
        return repository.save(movie);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable String id) {
        repository.deleteById(id);
        return "Movie deleted successfully";
    }

    @GetMapping("/details")
    public List<Object[]> getMovieScreenTheatre() {
        return repository.getMovieScreenTheatre();
    }
}
