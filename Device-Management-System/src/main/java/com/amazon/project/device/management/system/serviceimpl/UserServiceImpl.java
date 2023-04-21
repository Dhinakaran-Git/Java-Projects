package com.amazon.project.device.management.system.serviceimpl;

import com.amazon.project.device.management.system.entity.User;
import com.amazon.project.device.management.system.repositroy.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
}
