package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.Connection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionRowMapper implements RowMapper<Connection> {
    @Override
    public Connection mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Connection(
                rs.getObject("id", java.util.UUID.class),
                rs.getString("employerEmail"),
                rs.getString("studentEmail")
        );
    }
}
