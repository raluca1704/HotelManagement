package com.example.hotelmanagementreservation.model;

import lombok.Getter;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private Date checkInDate;
    private Date checkOutDate;
    private boolean canceled;

    public Reservation(int id, Room room, User user, Date checkInDate, Date checkOutDate, boolean canceled) {
        this.id = id;
        this.room = room;
        this.user = user;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.canceled = canceled;
    }

    public Reservation() {

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }


}