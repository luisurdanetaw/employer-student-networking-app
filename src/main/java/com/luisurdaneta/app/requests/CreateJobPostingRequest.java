package com.luisurdaneta.app.requests;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateJobPostingRequest {
    private String email;
    private String employerName;
    private String position;
    private Integer pay;
    private String location;
    private String description;

}
