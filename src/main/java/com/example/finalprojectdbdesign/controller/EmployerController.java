package com.example.finalprojectdbdesign.controller;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employer/")
public class EmployerController {
    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService){
        this.employerService = employerService;
    }

    @GetMapping("/getAllEmployers")
    public List<Employer> getAllEmployers(){
        return employerService.getAllEmployers();
    }

    @GetMapping("/search")
    public List<Employer> searchEmployer(@RequestParam String name){
       return employerService.searchEmployer(name);
    }

    @GetMapping("/page/{username}")
    public Employer getEmployerPage(@PathVariable String username){
        return employerService.getEmployerPage(username);
    }

}
