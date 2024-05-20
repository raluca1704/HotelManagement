package com.example.hotelmanagementreservation.service;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.repository.HotelRepository;
import com.example.hotelmanagementreservation.util.PositionCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findNearbyHotels(double userLat, double userLong, double radius) {
        List<Hotel> allHotels = hotelRepository.findAll();
        List<Hotel> nearbyHotels = new ArrayList<>();

        for (Hotel hotel : allHotels) {
            boolean withinRadius = PositionCalculation.isWithinRadius(userLat, userLong, hotel.getLatitude(), hotel.getLongitude(), radius);
            if (withinRadius) {
                nearbyHotels.add(hotel);
            }
        }

        return nearbyHotels;
    }
}
