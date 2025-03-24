package com.example.DeviceAtlas.controller;

import com.example.DeviceAtlas.entity.Device;
import com.example.DeviceAtlas.service.DeviceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/devices")
class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/fetch-devices")
    public ResponseEntity<String> fetchAndStoreDevices() {
        deviceService.fetchAndStoreDeviceData();
        return ResponseEntity.ok("Devices fetched and stored.");
    }

    @GetMapping("/tablets")
    public List<Device> getTablets() {
        return deviceService.getTablets();
    }

    @GetMapping("/all")
    public List<Device> getAll() {
        return deviceService.getAll();
    }
}



