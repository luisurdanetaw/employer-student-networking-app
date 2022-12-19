package com.example.finalprojectdbdesign.controller;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.lambda.model.AWSLambdaException;
import com.example.finalprojectdbdesign.fileStorage.StorageService;
import com.example.finalprojectdbdesign.model.Student;
import com.example.finalprojectdbdesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;
    private final StorageService storageService;

    @Autowired
    public StudentController(StudentService studentService, StorageService storageService){
        this.studentService = studentService;
        this.storageService = storageService;
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

    @GetMapping("downloadProfileImage")
    public byte [] downloadProfileImage(@RequestParam String username) {
            return studentService.downloadProfileImage(username);
    }

    @PostMapping(
            value= "uploadProfileImage",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadProfileImage(@RequestParam("username") String username, @RequestParam("image") MultipartFile image){
        try {
            studentService.uploadProfileImage(image, username);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


}
