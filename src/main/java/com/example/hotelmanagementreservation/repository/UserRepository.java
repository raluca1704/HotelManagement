package com.example.hotelmanagementreservation.repository;

import com.example.hotelmanagementreservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}