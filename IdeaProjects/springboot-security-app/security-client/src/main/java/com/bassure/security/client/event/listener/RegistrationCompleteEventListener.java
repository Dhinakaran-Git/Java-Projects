package com.bassure.security.client.event.listener;

import com.bassure.security.client.entity.UserDemo;
import com.bassure.security.client.event.RegisterCompleteEvent;
import com.bassure.security.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegisterCompleteEvent> {
    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegisterCompleteEvent event) {
        //create the verification token for the user
        UserDemo user = event.getUserDemo();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(user, token);
        //send email to user
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        System.out.println("This mail is verification mail : " + url);
    }
}
