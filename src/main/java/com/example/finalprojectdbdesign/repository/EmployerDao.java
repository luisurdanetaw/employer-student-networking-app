package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.Employer;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.SQLException;
import java.util.List;

public interface EmployerDao {
    List<Employer> findAll();
    List<Employer> findAllThatMatchName(String name);
    Employer findByUsername(String username);
    Employer findByEmail(String email);
    void insertEmployer(Employer e) throws DataIntegrityViolationException;

}
