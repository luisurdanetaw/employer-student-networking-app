package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JobApplicationDaoImpl implements JobApplicationDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobApplicationDaoImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<JobApplication> findAll(String email) {
        String sql = "SELECT * FROM Applications WHERE studentEmail = ?";
        return jdbcTemplate.query(
                sql,
                new JobApplicationRowMapper(),
                email
        );
    }

    @Override
    public void insertJobApplication(JobApplication j) {
        String sql = "INSERT INTO Applications (id, studentEmail, jobId)"
                + "VALUES (?,?,?)";
        jdbcTemplate.update(
                sql,
                j.getId(), j.getStudentEmail(), j.getJobId()
        );
    }
}
