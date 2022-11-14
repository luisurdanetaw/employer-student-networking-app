package com.example.finalprojectdbdesign.controller;

import com.example.finalprojectdbdesign.model.JobPosting;
import com.example.finalprojectdbdesign.requests.CreateJobPostingRequest;
import com.example.finalprojectdbdesign.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobs")
public class JobPostingController {
    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingController(JobPostingService jobPostingService){
        this.jobPostingService = jobPostingService;
    }

    @GetMapping
    public List<JobPosting> getJobPostings(){
        return jobPostingService.getJobPostings();
    }

    @PostMapping(
            value ="createJobPosting",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createJobPosting(@RequestBody CreateJobPostingRequest request){
        if(request.getEmail() == null || request.getPosition() == null || request.getPay() == null || request.getLocation() == null || request.getDescription() == null)
            return new ResponseEntity<>("Job properties cannot be null", HttpStatus.BAD_REQUEST);

        //handle sql exceptions and other bullshit
        jobPostingService.createJobPosting(request);
        return new ResponseEntity<>(
                "Job posting successfully created",
                HttpStatus.OK
        );
    }
}
