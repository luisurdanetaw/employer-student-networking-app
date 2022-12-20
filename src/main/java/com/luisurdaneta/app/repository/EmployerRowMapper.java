package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.Employer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployerRowMapper implements RowMapper<Employer>{

    @Override
    public Employer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employer(
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("industry"),
                rs.getString("location")
        );
    }
}
