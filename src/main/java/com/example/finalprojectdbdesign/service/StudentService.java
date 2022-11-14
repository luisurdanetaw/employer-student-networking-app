package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.model.Student;
import com.example.finalprojectdbdesign.repository.FakeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    private final FakeDB testDB;

    @Autowired
    public StudentService(FakeDB testDB){
        this.testDB = testDB;
    }

    public List<Student> searchStudent(String name) throws IllegalStateException {
        return testDB.searchStudentByName(name);
    }

    public Student getStudentPage(String username) throws IllegalStateException {
        return testDB.getStudentByUsername(username);
    }
}
