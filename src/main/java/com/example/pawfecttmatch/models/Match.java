package com.example.pawfecttmatch.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Match {
    private String matchId;
    private String user1Id;
    private String user2Id;
    private Date createdAt;

   
}
