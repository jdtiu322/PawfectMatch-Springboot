package com.example.pawfecttmatch.models;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String displayName;
    private String dogId;
    private String swipeId;
    private String matchId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String userId;
    private String password;

}
