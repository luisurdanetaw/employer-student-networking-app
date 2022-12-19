package com.example.finalprojectdbdesign.controller;

import com.example.finalprojectdbdesign.model.Connection;
import com.example.finalprojectdbdesign.requests.ConnectionRequest;
import com.example.finalprojectdbdesign.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/connections")
public class ConnectionController {

    private final ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService){
        this.connectionService = connectionService;
    }

    @GetMapping("/findAllStudent")
    public List<Connection> findAllStudentConnections(@RequestParam String email){
        return connectionService.findAllStudentConnections(email);
    }

    @PostMapping(
            value= "create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createConnection(@RequestBody ConnectionRequest request){
        try{
            connectionService.createConnection(request);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
