package com.example.DeviceAtlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.DeviceAtlas.repository")  // ✅ Explicitly enable JPA repositories
public class DeviceAtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceAtlasApplication.class, args);
	}

}
