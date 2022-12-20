package com.luisurdaneta.app.controller;

import com.luisurdaneta.app.model.JobPosting;
import com.luisurdaneta.app.requests.CreateJobPostingRequest;
import com.luisurdaneta.app.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
        try {
            jobPostingService.createJobPosting(request);
            return new ResponseEntity<>(
                    "Job posting successfully created",
                    HttpStatus.OK
            );
        }
        catch(DataIntegrityViolationException e){
            return new ResponseEntity<>("Job properties cannot be null", HttpStatus.BAD_REQUEST);
        }
    }
}
