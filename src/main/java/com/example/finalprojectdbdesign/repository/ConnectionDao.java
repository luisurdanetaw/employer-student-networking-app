package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.Connection;

import java.util.List;

public interface ConnectionDao {
    List<Connection> findAllStudentConnections(String email);
    void createConnection(Connection c);
}
