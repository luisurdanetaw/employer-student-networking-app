package com.luisurdaneta.app.service;

import com.luisurdaneta.app.model.Connection;
import com.luisurdaneta.app.repository.ConnectionDaoImpl;
import com.luisurdaneta.app.requests.ConnectionRequest;
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
