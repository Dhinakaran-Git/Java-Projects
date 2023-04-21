package com.bassure.springweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String sayHi(@RequestParam("username") String userName, Model model) {
        model.addAttribute("user", userName);
        return "hi";
    }
}
