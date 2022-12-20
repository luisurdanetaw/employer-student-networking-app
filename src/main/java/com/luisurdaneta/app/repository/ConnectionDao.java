package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.Connection;

import java.util.List;

public interface ConnectionDao {
    List<Connection> findAllStudentConnections(String email);
    void createConnection(Connection c);
}
