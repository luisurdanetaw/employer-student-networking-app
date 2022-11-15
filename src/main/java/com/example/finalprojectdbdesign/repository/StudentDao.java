package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.Student;
import org.springframework.dao.DataAccessException;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> findAllStudents();
    List<Student> findStudentsByName(String name) throws DataAccessException;
    Student findStudentByUsername(String username) throws DataAccessException;
    Student findStudentByEmail(String email);
    void insertStudent(Student s);


}
