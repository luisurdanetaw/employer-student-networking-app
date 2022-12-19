package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.repository.EmployerDao;
import com.example.finalprojectdbdesign.repository.EmployerDaoImpl;
import com.example.finalprojectdbdesign.repository.FakeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    private final FakeDB testDB;
    private final EmployerDao employerDao;

    @Autowired
    public EmployerService(FakeDB testDB, EmployerDaoImpl employerDao){
        this.testDB = testDB;
        this.employerDao = employerDao;
    }
    public List<Employer> searchEmployer(String name) {
        if(name.isBlank() || name.isEmpty()){
            return employerDao.findAll();
        }
        else return employerDao.findAllThatMatchName(name);
    }

    public Employer getEmployerPage(String username) {
        return employerDao.findByUsername(username);
    }

    public List<Employer> getAllEmployers(){
        return employerDao.findAll();
    }
}
