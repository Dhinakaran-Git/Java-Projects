package com.amazon.project.device.management.system.repositroy;

import com.amazon.project.device.management.system.entity.DeviceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceStatusRepo extends JpaRepository<DeviceStatus, Integer>{
    
}
