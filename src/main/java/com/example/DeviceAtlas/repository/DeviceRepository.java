package com.example.DeviceAtlas.repository;

import com.example.DeviceAtlas.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository  
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByPrimaryHardwareType(String primaryHardwareType);
}
