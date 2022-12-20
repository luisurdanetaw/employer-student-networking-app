package com.luisurdaneta.app.service;

import com.luisurdaneta.app.model.Employer;
import com.luisurdaneta.app.repository.EmployerDao;
import com.luisurdaneta.app.repository.EmployerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    private final EmployerDao employerDao;

    @Autowired
    public EmployerService(EmployerDaoImpl employerDao){
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
