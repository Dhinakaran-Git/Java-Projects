package com.bassure.learning.springmvc.lms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    @ResponseBody
    public String viewmethod() {
        return "hello";
    }
}
