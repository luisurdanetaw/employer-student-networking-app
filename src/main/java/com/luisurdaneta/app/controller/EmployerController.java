package com.luisurdaneta.app.controller;

import com.luisurdaneta.app.model.Employer;
import com.luisurdaneta.app.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
