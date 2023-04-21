package com.amazon.project.device.management.system.serviceimpl;

import com.amazon.project.device.management.system.entity.Device;
import com.amazon.project.device.management.system.repositroy.DeviceRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl {

    @Autowired
    private DeviceRepo deviceRepo;
    
    public List<Device> getAllDevices() {
        return deviceRepo.findAll();
    }
    
}
