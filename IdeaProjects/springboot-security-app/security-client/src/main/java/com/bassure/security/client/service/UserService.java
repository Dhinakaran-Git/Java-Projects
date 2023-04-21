package com.bassure.security.client.service;

import com.bassure.security.client.entity.UserDemo;
import com.bassure.security.client.modal.UserModal;

public interface UserService {
    public UserDemo registerUser(UserModal userModal);
    public void saveVerificationTokenForUser(UserDemo user, String token);
    public String validateVerificationToken(String token);
}
