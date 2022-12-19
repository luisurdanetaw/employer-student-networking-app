package com.example.finalprojectdbdesign.controller;

import com.example.finalprojectdbdesign.model.JobApplication;
import com.example.finalprojectdbdesign.requests.CreateJobApplicationRequest;
import com.example.finalprojectdbdesign.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/job-application")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationController(JobApplicationService jobApplicationService){
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping("/findAll")
    public List<JobApplication> findAllApplications (@RequestParam String email){
        return this.jobApplicationService.findAll(email);
    }
    @PostMapping(
            value ="/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createJobApplication(@RequestBody CreateJobApplicationRequest request){
        if(this.jobApplicationService.createJobApplication(request)){
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        else return new ResponseEntity<>("FAILED TO CREATE JOB APPLICATION", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
