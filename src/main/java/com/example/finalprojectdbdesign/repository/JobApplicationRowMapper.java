package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.JobApplication;
import com.example.finalprojectdbdesign.model.JobPosting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobApplicationRowMapper implements RowMapper<JobApplication> {
    @Override
    public JobApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new JobApplication(
                rs.getObject("id", java.util.UUID.class),
                rs.getString("studentEmail"),
                rs.getObject("jobId", java.util.UUID.class)
        );
    }
}
