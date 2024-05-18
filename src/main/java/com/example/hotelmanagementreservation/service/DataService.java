package com.example.hotelmanagementreservation.service;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.model.Room;
import com.example.hotelmanagementreservation.repository.HotelRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private HotelRepository hotelRepository;

    public void loadData() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Hotel>> typeReference = new TypeReference<>() {};
        InputStream inputStream = null;

        try {
            inputStream = new ClassPathResource("data/hotels.json").getInputStream();
            List<Hotel> hotels = mapper.readValue(inputStream, typeReference);

            // Save each hotel and its associated rooms
            for (Hotel hotel : hotels) {
                // Save hotel
                hotelRepository.save(hotel);

                // Save rooms associated with the hotel
                for (Room room : hotel.getRooms()) {
                    room.setHotel(hotel);
                }
            }
            System.out.println("Hotels data loaded!");

            // Check if the data is successfully stored in the MySQL database
            List<Hotel> savedHotels = hotelRepository.findAll();
            if (!savedHotels.isEmpty()) {
                System.out.println("Data successfully stored in the MySQL database:");
                for (Hotel savedHotel : savedHotels) {
                    System.out.println(savedHotel);
                }
            } else {
                System.out.println("No hotels found in the MySQL database.");
            }
        } catch (IOException e) {
            System.out.println("Unable to load hotels data: " + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
