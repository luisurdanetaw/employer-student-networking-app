package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Student> findAllStudents(){
        String sql = "SELECT * FROM Students";
        return jdbcTemplate.query(
                sql,
                new StudentRowMapper()
        );
    }
    public List<Student> findStudentsByName(String name) throws DataAccessException {
        String sql = "SELECT * FROM Students WHERE name = ?";
        return jdbcTemplate.query(
                sql,
                new StudentRowMapper(),
                name
        );
    }
    public Student findStudentByUsername(String username) throws DataAccessException{
        String sql = "SELECT * FROM Students WHERE username = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new StudentRowMapper(),
                username
        );
    }
    public Student findStudentByEmail(String email){
        String sql = "SELECT * FROM Students WHERE email = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new StudentRowMapper(),
                email
        );
    }
    public void insertStudent(Student s){
        String sql = "INSERT INTO Students (name, username, email, password, university, major, gpa) "
                + "VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                new StudentRowMapper(),
                s.getName(), s.getUsername(), s.getEmail(), s.getPassword(), s.getUniversity(), s.getMajor(), s.getGpa()
        );
    }


}
