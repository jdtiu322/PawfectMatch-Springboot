package com.example.pawfecttmatch.models;

import java.util.Date;

public class User {

    private String email;
    private String displayName;
    private String dogId; // Reference to the ID of the user's dog in Firestore
    private String swipeId; // Reference to the ID of the user's swipe in Firestore
    private String matchId; // Reference to the ID of the user's match in Firestore
    private Date createdAt;
    private Date updatedAt;
    private String userId;
    private String password;// ID of the user in Firestore

    // Constructors, getters, and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public String getSwipeId() {
        return swipeId;
    }

    public void setSwipeId(String swipeId) {
        this.swipeId = swipeId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
