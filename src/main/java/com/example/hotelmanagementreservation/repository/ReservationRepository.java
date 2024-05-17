package com.example.hotelmanagementreservation.repository;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository <Reservation, String>{
    Reservation findById(int id);
    void deleteById(int id);
}