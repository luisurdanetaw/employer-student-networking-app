package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.Employer;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public interface EmployerDao {
    List<Employer> findAll();
    List<Employer> findAllThatMatchName(String name);
    Employer findByUsername(String username);
    Employer findByEmail(String email);
    void insertEmployer(Employer e) throws DataIntegrityViolationException;

}
