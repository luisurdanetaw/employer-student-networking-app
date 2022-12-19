package com.example.finalprojectdbdesign.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class CreateJobApplicationRequest {
    private String studentEmail;
    private UUID jobId;


}
