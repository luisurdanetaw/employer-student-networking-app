package com.example.finalprojectdbdesign.requests;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateJobPostingRequest {
    private String email;
    private String position;
    private Integer pay;
    private String location;
    private String description;

}
