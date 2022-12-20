# Employer-Student Networking Web App

## Introduction
This project was built as a means of connecting students with employers. This repository contains the application’s backend. The links for the frontend and AWS Lambda Function Handler repositories are listed below:  
  
Frontend Repository: https://github.com/luisurdanetaw/networking-app-frontend  
AWS Lambda Function Handler Repository: https://github.com/luisurdanetaw/AWSLambdaThumbnailGenerator  
   
## Technology Stack
This application was built using the following technologies:
- PostgreSQL 14.2  (Database)
- Spring Boot 2.7.5 (Backend)
- Spring Data JDBC 2.7.5 (Backend)
- Angular  14.2.10 (Frontend)

## AWS Integration

The API provides two endpoints to download/upload images from/to Amazon S3.   
NOTE: The upload endpoint invokes an AWS Lambda function that will generate a thumbnail based on the original image, and then store this new image to s3.


## EER Diagram and Database Schema Design  
![EER-diagram-networking-app](https://user-images.githubusercontent.com/88799385/208592520-324900bd-176d-427c-a06d-c20939800422.PNG)
  

#### The three main data models in this application are Employers, Students and Jobs.   
These entities are related in the following ways:      
- connectsWith: Employers connect with students and vice versa. This is a many to many relation, partial on both sides, that will serve for networking purposes. 
- posts: Employers post jobs. This is a one to many relation, total on the jobs side and partial on the employers side. It is important to note that Job is a weak entity: it can only exist in the context of an employer.
- appliesTo: Students can apply to jobs. This is a many to many relation, partial on both sides.
Many to many relations require their own table, so the database for this application contains five tables: Students, Employers, Jobs, Applications, Connections.


## Password Encryption

Passwords are encrypted using BCryptPaswordEncoder provided by Spring Security. At login time, raw attempted password is encoded and matched to stored encoded password.

## Protection Against SQL Injection

User input during login and registration does not need to be manually sanitized to prevent SQL Injection in this application because the database interaction is performed with Spring JDBC. The methods used to communicate with the database (.update(), .query(), .queryForObject()) are provided by Spring JDBC's JdbcTemplate class, which automatically runs parameterized queries  or “prepared statements” which mitigate the risk of SQLInjection. 


## CHECK Constraints

A constraint was added to table Students make sure a Student’s gpa belongs to the interval [0, 4]:

## DATABASE INDEXES
An index with strategy B-Tree was added to Employers(name) to speed up selection of employers by name.   
idx_employer_name


## TODO/ISSUES

- Complete frontend
- Modify connection functionality to allow users to receive connection
- CORS Policy: the backend is set up to allow requests from all origins for development purposes. This leaves the application vulnerable to cross-site request forgery attacks.
- Replace alerts with popups/modals.
- Write the readme for the frontend






