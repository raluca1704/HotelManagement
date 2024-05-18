package com.example.hotelmanagementreservation.controller;

import com.example.hotelmanagementreservation.repository.HotelRepository;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelRepository hotelRepository;
    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    @GetMapping("/nearby")
    public List<Hotel> getNearbyHotels(@RequestParam double userLatitude, @RequestParam double userLongitude, @RequestParam double radius) {
        return hotelService.findNearbyHotels(userLatitude, userLongitude, radius);
    }

}

