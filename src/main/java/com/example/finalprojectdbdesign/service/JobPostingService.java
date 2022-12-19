package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.JobPosting;
import com.example.finalprojectdbdesign.repository.FakeDB;
import com.example.finalprojectdbdesign.repository.JobPostingDaoImpl;
import com.example.finalprojectdbdesign.requests.CreateJobPostingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {
    private final JobPostingDaoImpl jobPostingDao;

    @Autowired
    public JobPostingService(JobPostingDaoImpl jobPostingDao){
        this.jobPostingDao = jobPostingDao;
    }
    public List<JobPosting> getJobPostings() {
        return jobPostingDao.findAllJobPostings();
    }

    public void createJobPosting(CreateJobPostingRequest request) {
        JobPosting job = new JobPosting(
                request.getEmail(),
                request.getEmployerName(),
                request.getPosition(),
                request.getPay(),
                request.getLocation(),
                request.getDescription()
        );
        jobPostingDao.insertJobPosting(job);
    }
}
