package com.example.hotelmanagementreservation.repository;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.model.Reservation;
import com.example.hotelmanagementreservation.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository <Room, String>{
    Room findById(int id);
    void deleteById(int id);
}