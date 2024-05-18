package com.example.hotelmanagementreservation.service;
import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.repository.HotelRepository;
import com.example.hotelmanagementreservation.util.PositionCalculation;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findNearbyHotels(double userLat, double userLon, double radiusKm) {
        // Convert the radius from kilometers to degrees (approximation)
        double radiusInDegrees = radiusKm / 111.32;

        // Calculate the min and max latitude and longitude for the bounding box
        double minLat = userLat - radiusInDegrees;
        double maxLat = userLat + radiusInDegrees;
        double minLon = userLon - radiusInDegrees;
        double maxLon = userLon + radiusInDegrees;

        // Find hotels within the bounding box
        List<Hotel> hotels = hotelRepository.findByLatitudeBetweenAndLongitudeBetween(minLat, maxLat, minLon, maxLon);

        // Filter hotels by actual distance within the radius
        return hotels.stream()
                .filter(hotel -> PositionCalculation.isWithinRadius(userLat, userLon, hotel.getLatitude(), hotel.getLongitude(), radiusKm))
                .collect(Collectors.toList());
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}