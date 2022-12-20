package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JobPostingDaoImpl implements JobPostingDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobPostingDaoImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<JobPosting> findAllJobPostings() {
        String sql = "SELECT * FROM Jobs";
        return jdbcTemplate.query(
                sql,
                new JobPostingRowMapper()
        );
    }

    @Override
    public void insertJobPosting(JobPosting j) {
        String sql = "INSERT INTO Jobs (id, email, position, pay, location, description, employerName) " +
                "VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                j.getId(), j.getEmail(), j.getPosition(), j.getPay(), j.getLocation(), j.getDescription(), j.getEmployerName()
        );
    }

}
