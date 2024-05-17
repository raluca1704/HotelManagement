package com.example.hotelmanagementreservation.repository;

import com.example.hotelmanagementreservation.model.Hotel;
import com.example.hotelmanagementreservation.model.Reservation;
import com.example.hotelmanagementreservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(int id);
    void deleteById(int id);
}