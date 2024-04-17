package com.example.pawfecttmatch.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class User {
    private String userId;
    private String email;
    private String displayName;
    private Dog dog;
    private Swipe swipes;
    private Match matches;
    private Date createdAt;
    private Date updatedAt;
    @Id
    private String userID;


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

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Swipe getSwipes() {
        return swipes;
    }

    public void setSwipes(Swipe swipes) {
        this.swipes = swipes;
    }

    public Match getMatches() {
        return matches;
    }

    public void setMatches(Match matches) {
        this.matches = matches;
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

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }
}
