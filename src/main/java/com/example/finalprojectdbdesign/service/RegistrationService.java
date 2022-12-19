package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.model.Student;
import com.example.finalprojectdbdesign.repository.EmployerDaoImpl;
import com.example.finalprojectdbdesign.repository.FakeDB;
import com.example.finalprojectdbdesign.repository.StudentDaoImpl;
import com.example.finalprojectdbdesign.requests.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RegistrationService {
    private final StudentDaoImpl studentDao;
    private final EmployerDaoImpl employerDao;

    @Autowired
    public RegistrationService(StudentDaoImpl studentDao, EmployerDaoImpl employerDao){
        this.studentDao = studentDao;
        this.employerDao = employerDao;
    }
    public void register(RegistrationRequest request) throws IllegalStateException, DataIntegrityViolationException {
        if(request.getUserType().equals("EMPLOYER")){
            registerEmployer(request);
        }
        else if (request.getUserType().equals("STUDENT")){
            registerStudent(request);
        }
    }

    private void registerEmployer(RegistrationRequest request) throws DataIntegrityViolationException{
        employerDao.insertEmployer(new Employer(request.getName(), request.getUsername(), request.getEmail(), request.getPassword(), request.getIndustry(), request.getLocation() ));
    }
    private void registerStudent(RegistrationRequest request) throws DataIntegrityViolationException {
        studentDao.insertStudent(new Student(request.getName(), request.getUsername(), request.getEmail(), request.getPassword(), request.getUniversity(), request.getMajor(), request.getGpa()));
    }
}
