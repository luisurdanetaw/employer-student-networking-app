package com.luisurdaneta.app.repository;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@ComponentScan("com.example.finalprojectdbdesign.repository")
public class SpringJdbcConfig {

    @Bean
    public DataSource postgresDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/final_project_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");

        return dataSource;
    }
}