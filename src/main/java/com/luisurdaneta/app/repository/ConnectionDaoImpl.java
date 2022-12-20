package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ConnectionDaoImpl implements ConnectionDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConnectionDaoImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Connection> findAllStudentConnections(String email) {
        String sql = "SELECT * FROM Connections WHERE studentEmail = ?";
        return jdbcTemplate.query(
                sql,
                new ConnectionRowMapper(),
                email
        );
    }

    @Override
    public void createConnection(Connection c) {
        String sql = "INSERT INTO Connections (id, employerEmail, studentEmail) "
                + "VALUES (?,?,?)";
        jdbcTemplate.update(
                sql,
                c.getId(), c.getEmployerEmail(), c.getStudentEmail()
        );
    }
}
