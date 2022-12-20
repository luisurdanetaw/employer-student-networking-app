package com.luisurdaneta.app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Student {
    private String name;
    private String username;
    private String email;
    private String password;
    private String university;
    private String major;
    private float gpa;

    public Student(String name, String username, String email, String password, String university, String major, float gpa){
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.university = university;
        this.major = major;
        this.gpa = gpa;
    }

}
