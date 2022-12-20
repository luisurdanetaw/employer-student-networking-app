package com.luisurdaneta.app.requests;


import lombok.Getter;

@Getter

public class RegistrationRequest {

    private String userType;

    private String name;
    private String username;
    private String email;
    private String password;

    private String industry;
    private String location;

    private String university;
    private String major;
    private float gpa;

}
