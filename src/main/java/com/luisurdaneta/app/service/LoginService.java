package com.luisurdaneta.app.service;

import com.luisurdaneta.app.model.Employer;
import com.luisurdaneta.app.repository.EmployerDaoImpl;
import com.luisurdaneta.app.repository.StudentDaoImpl;
import com.luisurdaneta.app.requests.LoginRequest;
import com.luisurdaneta.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    private final EmployerDaoImpl employerDao;
    private final StudentDaoImpl studentDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(EmployerDaoImpl employerDao, StudentDaoImpl studentDao, PasswordEncoder passwordEncoder){
        this.employerDao = employerDao;
        this.studentDao = studentDao;
        this.passwordEncoder = passwordEncoder;
    }

    public String loginStudent(LoginRequest request) {
        Student s = studentDao.findStudentByEmail(request.getEmail());
        if(Objects.isNull(s)){
            return "EMAIL DOES NOT EXIST";
        }
        if(authenticate(s, request.getPassword()))
            return s.getUsername();
        return "WRONG PASSWORD";
    }
    public String loginEmployer(LoginRequest request) {
        Employer e = employerDao.findByEmail(request.getEmail());
        if(Objects.isNull(e)){
            return "EMAIL DOES NOT EXIST";
        }
        if(authenticate(e, request.getPassword()))
            return "SUCCESS";
        return "WRONG PASSWORD";
    }

    private boolean authenticate(Student s, String password) {
        return passwordEncoder.matches(password, s.getPassword());
    }
    private boolean authenticate(Employer e, String password) {
        return passwordEncoder.matches(password, e.getPassword());
    }
}
