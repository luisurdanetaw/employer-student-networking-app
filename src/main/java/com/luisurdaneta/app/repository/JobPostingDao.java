package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.JobPosting;

import java.util.List;

public interface JobPostingDao {
    List<JobPosting> findAllJobPostings();
    void insertJobPosting(JobPosting j);
}
