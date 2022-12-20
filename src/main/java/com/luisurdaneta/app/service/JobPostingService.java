package com.luisurdaneta.app.service;

import com.luisurdaneta.app.model.JobPosting;
import com.luisurdaneta.app.repository.JobPostingDaoImpl;
import com.luisurdaneta.app.requests.CreateJobPostingRequest;
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
