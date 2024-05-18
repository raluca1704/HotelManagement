package com.example.hotelmanagementreservation.controller;

import com.example.hotelmanagementreservation.model.Room;
import com.example.hotelmanagementreservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id) {
        return roomRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
    }
    @GetMapping("/api/hotels/{hotelId}/rooms")
    public List<Room> getRoomsByHotelId(@PathVariable int hotelId) {

        return roomRepository.findByHotelId(hotelId);
    }



}
