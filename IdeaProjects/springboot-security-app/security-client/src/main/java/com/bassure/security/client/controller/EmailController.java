package com.bassure.security.client.controller;

import com.bassure.security.client.modal.EmailDetails;
import com.bassure.security.client.service.EmailSenderService;
import com.bassure.security.client.serviceImpl.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailSenderServiceImpl emailSenderService;

    @PostMapping("/send-mail")
    public String sendNewMail(@RequestBody EmailDetails emailDetails){
        this.emailSenderService.sendMail(
                emailDetails.getTo(),
                emailDetails.getSubject(),
                emailDetails.getMessage()
        );
        return "email send Success";
    }
}
