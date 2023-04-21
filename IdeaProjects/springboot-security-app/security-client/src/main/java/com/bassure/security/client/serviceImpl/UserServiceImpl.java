package com.bassure.security.client.serviceImpl;

import com.bassure.security.client.entity.UserDemo;
import com.bassure.security.client.entity.VerificationToken;
import com.bassure.security.client.repository.VerificationTokenRepository;
import com.bassure.security.client.service.UserService;
import com.bassure.security.client.modal.UserModal;
import com.bassure.security.client.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);

    @Override
    public UserDemo registerUser(UserModal userModal) {
        UserDemo user = new UserDemo();
        user.setFirstName(userModal.getFirstName());
        user.setLastName(userModal.getLastName());
        user.setEmail(userModal.getEmail());
        user.setPassword(passwordEncoder.encode(userModal.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(UserDemo user, String token) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        System.out.println(verificationToken);
        if (verificationToken.getToken() == null) {
            return "invalid";
        }
        UserDemo user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();

        if (verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime() <= 0) {
            verificationTokenRepository.delete(verificationToken);
            return "expired";
        } else {
            user.setEnable(true);
            userRepository.save(user);
            return "valid";
        }
    }
}
