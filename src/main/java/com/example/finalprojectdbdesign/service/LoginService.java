package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.requests.LoginRequest;
import com.example.finalprojectdbdesign.model.Student;
import com.example.finalprojectdbdesign.repository.FakeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    private final FakeDB testDB;
    @Autowired
    public LoginService(FakeDB testDB){
        this.testDB = testDB;
    }

    public String loginStudent(LoginRequest request) {
        Student s = testDB.findStudentByEmail(request.getEmail());
        if(Objects.isNull(s)){
            return "EMAIL DOES NOT EXIST";
        }
        if(authenticate(s, request.getPassword()))
            return "SUCCESS";
        return "WRONG PASSWORD";
    }
    public String loginEmployer(LoginRequest request) {
        Employer e = testDB.findEmployerByEmail(request.getEmail());
        if(Objects.isNull(e)){
            return "EMAIL DOES NOT EXIST";
        }
        if(authenticate(e, request.getPassword()))
            return "SUCCESS";
        return "WRONG PASSWORD";
    }

    private boolean authenticate(Student s, String password) {
        return s.getPassword().equals(password);
    }
    private boolean authenticate(Employer e, String password) {
        return e.getPassword().equals(password);
    }
}
