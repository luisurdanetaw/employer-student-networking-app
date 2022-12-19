package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.JobPosting;

import java.util.List;

public interface JobPostingDao {
    List<JobPosting> findAllJobPostings();
    void insertJobPosting(JobPosting j);
}
