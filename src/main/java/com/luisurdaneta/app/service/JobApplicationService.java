package com.luisurdaneta.app.service;

import com.luisurdaneta.app.model.JobApplication;
import com.luisurdaneta.app.repository.JobApplicationDaoImpl;
import com.luisurdaneta.app.requests.CreateJobApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {
    private final JobApplicationDaoImpl jobApplicationDao;

    @Autowired
    public JobApplicationService(JobApplicationDaoImpl jobApplicationDao){
        this.jobApplicationDao = jobApplicationDao;
    }

    public List<JobApplication> findAll(String email) {
        return jobApplicationDao.findAll(email);
    }

    public boolean createJobApplication(CreateJobApplicationRequest request) {
            jobApplicationDao.insertJobApplication(new JobApplication(request.getStudentEmail(), request.getJobId()));
            return true;

    }
}
