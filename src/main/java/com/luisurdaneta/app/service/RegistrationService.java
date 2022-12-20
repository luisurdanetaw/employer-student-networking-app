package com.luisurdaneta.app.service;

import com.luisurdaneta.app.model.Employer;
import com.luisurdaneta.app.model.Student;
import com.luisurdaneta.app.repository.EmployerDaoImpl;
import com.luisurdaneta.app.repository.StudentDaoImpl;
import com.luisurdaneta.app.requests.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final StudentDaoImpl studentDao;
    private final EmployerDaoImpl employerDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(StudentDaoImpl studentDao, EmployerDaoImpl employerDao, PasswordEncoder encoder){
        this.studentDao = studentDao;
        this.employerDao = employerDao;
        this.passwordEncoder = encoder;
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
        employerDao.insertEmployer(
                new Employer(
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getIndustry(),
                        request.getLocation()
                )
        );
    }
    private void registerStudent(RegistrationRequest request) throws DataIntegrityViolationException {
        studentDao.insertStudent(
                new Student(
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getUniversity(),
                        request.getMajor(),
                        request.getGpa()
                )
        );
    }
}
