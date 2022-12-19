package com.example.finalprojectdbdesign.repository;


import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.model.JobPosting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobPostingRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new JobPosting(
                rs.getObject("id", java.util.UUID.class),
                rs.getString("email"),
                rs.getString("employerName"),
                rs.getString("position"),
                rs.getInt("pay"),
                rs.getString("location"),
                rs.getString("description")
        );
    }
}
