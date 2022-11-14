package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.model.Student;
import com.example.finalprojectdbdesign.repository.FakeDB;
import com.example.finalprojectdbdesign.requests.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final FakeDB testDB;

    @Autowired
    public RegistrationService(FakeDB testDB){
        this.testDB = testDB;
    }
    public void register(RegistrationRequest request) throws IllegalStateException {
        if(request.getUserType().equals("EMPLOYER")){
            registerEmployer(request);
        }
        else if (request.getUserType().equals("STUDENT")){
            registerStudent(request);
        }
    }

    private void registerEmployer(RegistrationRequest request) throws IllegalStateException{
        testDB.addEmployer(new Employer(request.getName(), request.getUsername(), request.getEmail(), request.getPassword(), request.getIndustry(), request.getLocation() ));
    }
    private void registerStudent(RegistrationRequest request) {
        testDB.addStudent(new Student(request.getName(), request.getUsername(), request.getEmail(), request.getPassword(), request.getUniversity(), request.getMajor(), request.getGpa() ));
    }
}
