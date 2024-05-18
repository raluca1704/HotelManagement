package com.example.hotelmanagementreservation.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getName() {
        return name;
    }

    private double latitude;

    private double longitude;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
    private List<Room> rooms;

    private String name;

    public Hotel(int id, String name, double latitude, double longitude, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rooms = rooms;
    }

    public Hotel() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


}

