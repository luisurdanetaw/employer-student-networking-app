package com.luisurdaneta.app.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.Entity;
//import javax.persistence.Id;
import java.util.HashMap;
import java.util.UUID;


@EqualsAndHashCode
@Setter
@Getter
//@Entity
public class Employer {
    //@Id
    private String name;
    private String username;
    private String email;
    private String password;
    private String industry;
    private String location;

    public Employer(String name, String username, String email, String password, String industry, String location){
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.industry = industry;
        this.location = location;

    }


}
