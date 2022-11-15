package com.example.finalprojectdbdesign.controller;

import com.example.finalprojectdbdesign.model.Student;
import com.example.finalprojectdbdesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudent(@RequestParam String name){
        try{
        List<Student> list = studentService.searchStudent(name);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/page/{username}")
    public ResponseEntity<Student> getStudentPage(@PathVariable String username){
        try{
            Student student = studentService.getStudentPage(username);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
