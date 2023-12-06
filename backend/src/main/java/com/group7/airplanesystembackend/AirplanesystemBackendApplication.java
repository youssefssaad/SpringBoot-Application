package com.group7.airplanesystembackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.group7.airplanesystembackend.entity")
public class AirplanesystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirplanesystemBackendApplication.class, args);
	}

}
