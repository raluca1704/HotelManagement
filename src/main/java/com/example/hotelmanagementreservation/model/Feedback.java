package com.example.hotelmanagementreservation.model;

import lombok.Getter;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Entity
public class Feedback {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int rating; // e.g., from 1 to 5
    private String comment;
    private Date feedbackDate;

    // Constructors
    public Feedback() {
    }

    public Feedback(Hotel hotel, User user, int rating, String comment, Date feedbackDate) {
        this.hotel = hotel;
        this.user = user;
        this.rating = rating;
        this.comment = comment;
        this.feedbackDate = feedbackDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}
