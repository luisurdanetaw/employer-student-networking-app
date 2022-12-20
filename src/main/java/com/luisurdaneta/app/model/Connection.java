package com.luisurdaneta.app.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Connection {
    private final UUID id;
    private final String employerEmail;
    private final String studentEmail;

    public Connection(String employerEmail, String studentEmail){
        this.id = UUID.randomUUID();
        this.employerEmail = employerEmail;
        this.studentEmail = studentEmail;
    }
    public Connection(UUID id, String employerEmail, String studentEmail){
        this.id = id;
        this.employerEmail = employerEmail;
        this.studentEmail = studentEmail;
    }
}
