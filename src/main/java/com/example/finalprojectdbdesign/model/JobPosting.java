package com.example.finalprojectdbdesign.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class JobPosting {
    private final UUID id;
    private final String email; //FK references Employer
    private String position;
    private Integer pay;
    private String location;
    private String description;

    public JobPosting(String email, String position, Integer pay, String location, String description){
        this.id = UUID.randomUUID();
        this.email = email;
        this.position = position;
        this.pay = pay;
        this.location = location;
        this.description = description;
    }
}
