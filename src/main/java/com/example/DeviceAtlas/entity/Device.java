package com.example.DeviceAtlas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "devices", schema = "dbo")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String vendor;
    private String osName;
    private String osVersion;
    private String browserName;
    private String primaryHardwareType;

    // ✅ Default Constructor
    public Device() {}

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }
    public String getOsName() { return osName; }
    public void setOsName(String osName) { this.osName = osName; }
    public String getOsVersion() { return osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }
    public String getBrowserName() { return browserName; }
    public void setBrowserName(String browserName) { this.browserName = browserName; }
    public String getPrimaryHardwareType() { return primaryHardwareType; }
    public void setPrimaryHardwareType(String primaryHardwareType) { this.primaryHardwareType = primaryHardwareType; }
}
