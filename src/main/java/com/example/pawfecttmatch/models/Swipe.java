package com.example.pawfecttmatch.models;

import java.util.Date;

public class Swipe {

    private String action;
    private Date createdAt;
    private String swipeId; // ID of the swipe in Firestore
    private String userId; // Reference to the ID of the user in Firestore
    private String dogId; // Reference to the ID of the dog in Firestore

    // Constructors, getters, and setters

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSwipeId() {
        return swipeId;
    }

    public void setSwipeId(String swipeId) {
        this.swipeId = swipeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }
}
