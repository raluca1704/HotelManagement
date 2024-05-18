package com.example.hotelmanagementreservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Room {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    private int roomNumber;
    @Getter
    private int type;
    @JsonProperty("isAvailable")
    private boolean isAvailable;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    @Getter
    private double price;

    public Room(int id, int roomNumber, int type, double price, boolean isAvailable, Hotel hotel) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
        this.hotel = hotel;
    }

    public Room() {

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public boolean isAvailable() {
//        return isAvailable;
//    }

//    public void setAvailable(boolean available) {
//        isAvailable = available;
//    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;

    }
}