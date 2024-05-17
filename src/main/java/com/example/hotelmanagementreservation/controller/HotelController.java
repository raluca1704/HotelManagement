package com.example.hotelmanagementreservation.controller;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    // Get all hotels
    @GetMapping
    public Iterable<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Get a hotel by ID
    @GetMapping("/{id}")
    public Optional<Hotel> getHotelById(@PathVariable int id) {
        return Optional.ofNullable(hotelRepository.findById(id));
    }

    // Delete a hotel by ID
    @DeleteMapping("/{id}")
    public String deleteHotelById(@PathVariable int id) {
        hotelRepository.deleteById(id);
        return "Hotel deleted successfully";
    }
}


