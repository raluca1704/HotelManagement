package com.example.hotelmanagementreservation.model;

//import lombok.Getter;
//
//import javax.persistence.*;
//import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//@Getter
@Entity
public class Hotel {
    private String name;
    @Id
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private double latitude;
//    private double longitude;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
//    private List<Room> rooms;
//    private String name;
//
//    public Hotel(int id, String name, double latitude, double longitude, List<Room> rooms) {
//        this.id = id;
//        this.name = name;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.rooms = rooms;
//    }
//
//    public Hotel() {
//
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public void setRooms(List<Room> rooms) {
//        this.rooms = rooms;
//    }
//
//
//}
//
