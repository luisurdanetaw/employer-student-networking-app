package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.JobApplication;

import java.util.List;

public interface JobApplicationDao {
    List<JobApplication> findAll(String email);
    void insertJobApplication(JobApplication j);
}
