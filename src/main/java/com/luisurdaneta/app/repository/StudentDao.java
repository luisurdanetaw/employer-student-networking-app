package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public interface StudentDao {
    List<Student> findAllStudents();
    List<Student> findStudentsByName(String name) throws DataAccessException;
    Student findStudentByUsername(String username) throws DataAccessException;
    Student findStudentByEmail(String email);
    void insertStudent(Student s) throws DataIntegrityViolationException;


}
