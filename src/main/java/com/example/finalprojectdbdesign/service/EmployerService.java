package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.repository.FakeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    private final FakeDB testDB;
    @Autowired
    public EmployerService(FakeDB testDB){
        this.testDB = testDB;
    }
    public List<Employer> searchEmployer(String name) {
        return testDB.searchEmployerByName(name);
    }

    public Employer getEmployerPage(String username) {
        return testDB.getEmployerByUsername(username);
    }
}
