package com.domain.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

    public String welcome(){
        return "welcome to Spring Boot Rest API";
        
    }
    
}
