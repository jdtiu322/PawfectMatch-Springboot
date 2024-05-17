package com.example.pawfecttmatch.models;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Dog {

    private String dogId;
    private String dogName;
    private int dogAge;
    private String size;
    private String imageUrl;
    private String ownerId;
    private String breed;
    private String gender;
    private String ownerName;
    private boolean isNeutered;
    private boolean isPurebred;
    private boolean isVaccinated;
     // Reference to the owner's user ID in Firestore
}
