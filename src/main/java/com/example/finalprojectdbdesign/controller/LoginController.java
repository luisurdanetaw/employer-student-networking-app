package com.example.finalprojectdbdesign.controller;

import com.example.finalprojectdbdesign.requests.LoginRequest;
import com.example.finalprojectdbdesign.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/login")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping(
            value = "studentAuth",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> loginStudent(@RequestBody LoginRequest request){
        String status = loginService.loginStudent(request);
        if(status.equals("EMAIL DOES NOT EXIST")){
            return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
        }
        else if(status.equals("WRONG PASSWORD")){
            return new ResponseEntity<>(status, HttpStatus.UNAUTHORIZED);
        }
        else
            return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @PostMapping(
            value ="employerAuth",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> loginEmployer(@RequestBody LoginRequest request){
        String status = loginService.loginEmployer(request);
        if(status.equals("SUCCESS")){
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        else if(status.equals("WRONG PASSWORD")){
            return new ResponseEntity<>(status, HttpStatus.UNAUTHORIZED);
        }
        else
            return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);

    }


}
