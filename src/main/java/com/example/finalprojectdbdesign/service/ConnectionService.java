package com.example.finalprojectdbdesign.service;

import com.example.finalprojectdbdesign.model.Connection;
import com.example.finalprojectdbdesign.repository.ConnectionDaoImpl;
import com.example.finalprojectdbdesign.requests.ConnectionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService {
    private final ConnectionDaoImpl connectionDao;

    @Autowired
    public ConnectionService(ConnectionDaoImpl connectionDao){
        this.connectionDao = connectionDao;
    }


    public void createConnection(ConnectionRequest request) {
        Connection c = new Connection(
                request.getEmployerEmail(),
                request.getStudentEmail()
        );
        connectionDao.createConnection(c);
    }

    public List<Connection> findAllStudentConnections(String email) {
        return connectionDao.findAllStudentConnections(email);
    }
}
