package com.amazon.project.device.management.system.controller;

import com.amazon.project.device.management.system.serviceimpl.DeviceServiceImpl;
import com.amazon.project.device.management.system.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserDeviceController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private DeviceServiceImpl deviceServiceImpl;

    @GetMapping("/user")
    @ResponseBody
    public String getUsers(Model model) {
        Model s = model.addAttribute("users", userServiceImpl.getAllUsers());
        return "user" + s;
    }

    @GetMapping("/device")
    @ResponseBody
    public String getDevices(Model model) {
        Model s = model.addAttribute("device", deviceServiceImpl.getAllDevices());
        return "device" + s;
    }
    
    
}
