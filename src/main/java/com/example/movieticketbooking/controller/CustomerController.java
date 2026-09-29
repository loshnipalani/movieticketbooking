package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.entity.Customer;
import com.example.movieticketbooking.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable String id) {
        repository.deleteById(id);
        return "Customer deleted successfully";
    }

    @GetMapping("/bookings")
    public List<Object[]> getCustomerBookingDetails() {
        return repository.getCustomerBookingDetails();
    }
}