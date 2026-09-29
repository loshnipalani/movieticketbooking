package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.entity.Screen;
import com.example.movieticketbooking.repository.ScreenRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    private final ScreenRepository repository;

    public ScreenController(ScreenRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Screen> getAllScreens() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Screen getScreen(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Screen addScreen(@RequestBody Screen screen) {
        return repository.save(screen);
    }

    @PutMapping
    public Screen updateScreen(@RequestBody Screen screen) {
        return repository.save(screen);
    }

    @DeleteMapping("/{id}")
    public String deleteScreen(@PathVariable String id) {
        repository.deleteById(id);
        return "Screen deleted successfully";
    }

    @GetMapping("/details")
    public List<Object[]> getScreenTheatreDetails() {
        return repository.getScreenTheatreDetails();
    }
}
