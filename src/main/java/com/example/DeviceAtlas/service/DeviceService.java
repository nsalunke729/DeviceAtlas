package com.example.DeviceAtlas.service;

import com.example.DeviceAtlas.entity.Device;
import java.util.Collections;
import com.example.DeviceAtlas.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Value("${deviceatlas.api.url}")  // Read from properties
    private String apiBaseUrl;

    @Value("${deviceatlas.license.key}")  // Read from properties
    private String licenseKey;


    private final String[] USER_AGENTS = {
        "Mozilla/5.0 (Linux; Android 7.0; Pixel C Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/52.0.2743.98 Safari/537.36 © DeviceAtlas Ltd 2025 Confidential",
        "Mozilla/5.0 (Linux; Android 10; MAR-LX1A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36",
        "Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.0 Mobile/15E148 Safari/604.1",
        "Mozilla/5.0 (Linux; Android 4.4.3; KFTHWI Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Silk/47.1.79 like Chrome/47.0.2526.80 Safari/537.36",
        "Mozilla/5.0 (iPad; CPU OS 18_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/112.0.5615.46 Mobile/15E148 Safari/604.1",
        "Mozilla/5.0 (Linux; Android 12; Redmi Note 9 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36",
        "Mozilla/5.0 (Linux; Android 12; SM-X906C Build/QP1A.190711.020; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/80.0.3987.119 Mobile Safari/537.36",
        "Dalvik/2.1.0 (Linux; U; Android 10; ACTAB1021 Build/QP1A.190711.020)",
        "Mozilla/5.0 (Linux; Android 13; SM-A515U) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36",
        "Mozilla/5.0 (Linux; Android 5.0.2; LG-V410/V41020c Build/LRX22G) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/34.0.1847.118 Safari/537.36"    
    };


    public void fetchAndStoreDeviceData() {
        RestTemplate restTemplate = new RestTemplate();
        deviceRepository.deleteAll();
        for (String userAgent : USER_AGENTS) {
            String url = apiBaseUrl + "?licencekey=" + licenseKey + "&useragent=" + userAgent;  // ✅ Construct URL dynamically
            DeviceResponse response = restTemplate.getForObject(url, DeviceResponse.class);
            if (response != null && response.getProperties() != null) {
                Device device = response.getProperties();
                deviceRepository.save(device);  // save data to DB
            }
        }
    }

    public List<Device> getTablets() {
        return deviceRepository.findByPrimaryHardwareType("Tablet");
    }

    public List<Device> getAll(){
        return deviceRepository.findAll();
    }
}

class DeviceResponse {
    private Device properties;

    public Device getProperties() {
        return properties;
    }

    public void setProperties(Device properties) {
        this.properties = properties;
    }
}