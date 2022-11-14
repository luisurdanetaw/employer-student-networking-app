package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.JobPosting;
import com.example.finalprojectdbdesign.repository.FakeDB;
import com.example.finalprojectdbdesign.requests.CreateJobPostingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {
    private final FakeDB testDB;
    public JobPostingService(FakeDB testDB){
        this.testDB = testDB;
    }
    public List<JobPosting> getJobPostings() {
        return testDB.getFakeJobPostingTable();
    }

    public void createJobPosting(CreateJobPostingRequest request) {
        JobPosting job = new JobPosting(
                request.getEmail(),
                request.getPosition(),
                request.getPay(),
                request.getLocation(),
                request.getDescription()
        );
        testDB.saveJob(job);
    }
}
