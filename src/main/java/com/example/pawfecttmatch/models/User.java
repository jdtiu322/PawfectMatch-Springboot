package com.example.pawfecttmatch.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class User {

    private String email;
    private String displayName;
    private String dogId;
    private String swipeId;
    private String matchId;
    private Date createdAt;
    private Date updatedAt;
    private String userId;
    private String password;
    private String documentId;
    
}
