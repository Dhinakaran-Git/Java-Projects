package com.bassure.learning.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    
    @GetMapping("/now")
    public String get(){
        return "hi";
    }
    
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}
