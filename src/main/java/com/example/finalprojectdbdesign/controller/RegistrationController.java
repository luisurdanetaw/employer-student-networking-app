package com.example.finalprojectdbdesign.controller;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.requests.RegistrationRequest;
import com.example.finalprojectdbdesign.service.EmployerService;
import com.example.finalprojectdbdesign.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/registration/")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping(
            value= "register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request){
        try {
            registrationService.register(request);
        } catch (IllegalStateException e){
            return new ResponseEntity<>("Email taken", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Registration succesful", HttpStatus.OK);
    }


}
