package com.example.finalprojectdbdesign.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class JobApplication {
    private final UUID id;
    private final String studentEmail; //References student
    private final UUID jobId; //References jobId

    public JobApplication(String studentEmail, UUID jobId){
        this.id = UUID.randomUUID();
        this.studentEmail = studentEmail;
        this.jobId = jobId;
    }
    public JobApplication(UUID id, String studentEmail, UUID jobId){
        this.id = id;
        this.studentEmail = studentEmail;
        this.jobId = jobId;
    }
}
