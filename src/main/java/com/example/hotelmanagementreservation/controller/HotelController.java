package com.example.hotelmanagementreservation.controller;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.repository.HotelRepository;
import com.example.hotelmanagementreservation.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @GetMapping
    public List<Hotel> getNearbyHotels(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius) {
        return hotelService.findNearbyHotels(latitude, longitude, radius);
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }
}



