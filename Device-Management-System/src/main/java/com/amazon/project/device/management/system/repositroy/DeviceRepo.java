package com.amazon.project.device.management.system.repositroy;

import com.amazon.project.device.management.system.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Integer>{
    
}
