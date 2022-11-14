package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployerDaoImpl implements EmployerDao {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployerDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employer> findAll() {
        String sql = "SELECT * FROM Employers";
        return jdbcTemplate.query(
                sql,
                new EmployerRowMapper()
        );
    }
    public List<Employer> findAllThatMatchName(String name){
        return null;
    }
    public Employer findByUsername(String username){
        String sql = "SELECT * FROM Employers WHERE username = ?";

        return jdbcTemplate.queryForObject(sql,
                new EmployerRowMapper(),
                username
        );
    }

    public Employer findByEmail(String email){
        String sql = "SELECT * FROM Employers WHERE email = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new EmployerRowMapper(),
                email
        );
    }
    public void insertEmployer(Employer e){
        String sql = "INSERT INTO Employers (name, username, email, password, industry, location) "
                + "VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                e.getName(), e.getUsername(), e.getEmail(), e.getPassword(), e.getIndustry(), e.getLocation()
        );

    }

}
