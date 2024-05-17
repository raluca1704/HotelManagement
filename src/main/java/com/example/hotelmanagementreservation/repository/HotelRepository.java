package com.example.hotelmanagementreservation.repository;

import com.example.hotelmanagementreservation.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository <Hotel, String>{
        List<Hotel> findByName(String name);
        Hotel findById(int id);
        void deleteById(int id);
}