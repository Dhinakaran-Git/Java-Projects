package com.bassure.security.client.controller;

import com.bassure.security.client.entity.UserDemo;
import com.bassure.security.client.event.RegisterCompleteEvent;
import com.bassure.security.client.serviceImpl.UserServiceImpl;
import com.bassure.security.client.modal.UserModal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/hi")
    public String welcome() {
        return "hi";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModal userModal, final HttpServletRequest request) {
        UserDemo user = userServiceImpl.registerUser(userModal);
        publisher.publishEvent(new RegisterCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "The User is : " + user;
    }

    @GetMapping("/verifyRegistration")
    public String verifyUser(@RequestParam("token") String token) {
        String result = userServiceImpl.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid")) {
            return "User register Success please verify your mail";
        } else {
            return "Bad User";
        }
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}
