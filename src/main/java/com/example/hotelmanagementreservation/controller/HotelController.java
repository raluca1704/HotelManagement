package com.example.hotelmanagementreservation.controller;

import com.example.hotelmanagementreservation.model.Room;
import com.example.hotelmanagementreservation.repository.HotelRepository;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.repository.RoomRepository;
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
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    @GetMapping("/nearby")
    public List<Hotel> getNearbyHotels(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius){
        return hotelService.findNearbyHotels(latitude,longitude, radius);
    }
    @GetMapping("/{hotelId}/rooms")
    public List<Room> getRoomsByHotelId(@PathVariable Long hotelId) {

        return roomRepository.findByHotelId(Math.toIntExact(hotelId));
    }
}

