package com.application.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "BooksWagon";
    }

    @GetMapping(value = "/about")
    public String about() {
        return "about";
    }
}
