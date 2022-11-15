package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.model.Student;
import com.example.finalprojectdbdesign.repository.FakeDB;
import com.example.finalprojectdbdesign.repository.StudentDao;
import com.example.finalprojectdbdesign.repository.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public List<Student> searchStudent(String name) throws DataAccessException {
        List<Student> list = studentDao.findStudentsByName(name);
        if(list.isEmpty()) throw new EmptyResultDataAccessException("Result set expected to be greater than 1.", 1);
        return list;
    }

    public Student getStudentPage(String username) throws DataAccessException {
            return studentDao.findStudentByUsername(username);
    }
}
