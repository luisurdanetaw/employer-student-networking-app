package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.JobApplication;

import java.util.List;

public interface JobApplicationDao {
    List<JobApplication> findAll(String email);
    void insertJobApplication(JobApplication j);
}
