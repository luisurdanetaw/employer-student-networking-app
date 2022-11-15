package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("university"),
                rs.getString("major"),
                rs.getFloat("gpa")
        );
    }
}
