package com.bassure.security.client.service;

public interface EmailSenderService {
    public void sendMail(String to, String subject, String message);
}
