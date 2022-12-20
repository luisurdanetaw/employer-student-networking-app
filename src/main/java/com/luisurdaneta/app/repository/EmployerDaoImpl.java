package com.luisurdaneta.app.repository;

import com.luisurdaneta.app.model.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Component
public class EmployerDaoImpl implements EmployerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployerDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employer> findAll() {
        String sql = "SELECT * FROM Employers";
        return jdbcTemplate.query(
                sql,
                new EmployerRowMapper()
        );
    }
    public List<Employer> findAllThatMatchName(String name){
        String nameForQuery = '%' + name + '%';
        String sql = "SELECT * FROM Employers WHERE LOWER(name) LIKE LOWER(?)";

        return jdbcTemplate.query(sql,
                new EmployerRowMapper(),
                nameForQuery
        );
    }
    //e
    public List<Employer> findAllThatMatchName(Stack<String> params){
        List<Employer> result = new ArrayList<>();
        while(!params.isEmpty()){
            String keyword = params.pop();

            String queryNameValue = '%' + keyword + '%';
            String sql = "SELECT * FROM Employers WHERE LOWER(name) LIKE LOWER(?)";

            result.addAll(
                    jdbcTemplate.query(sql,
                    new EmployerRowMapper(),
                    queryNameValue
                )
            );
        }

        return result;
    }
    public Employer findByUsername(String username){
        String sql = "SELECT * FROM Employers WHERE username = ?";

        return jdbcTemplate.queryForObject(sql,
                new EmployerRowMapper(),
                username
        );
    }

    public Employer findByEmail(String email){
        String sql = "SELECT * FROM Employers WHERE email = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new EmployerRowMapper(),
                email
        );
    }
    public void insertEmployer(Employer e) throws DataIntegrityViolationException {
        String sql = "INSERT INTO Employers (name, username, email, password, industry, location) "
                + "VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                e.getName(), e.getUsername(), e.getEmail(), e.getPassword(), e.getIndustry(), e.getLocation()
        );

    }

}
