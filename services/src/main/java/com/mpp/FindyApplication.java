package com.mpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
@EnableCaching
public class FindyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindyApplication.class, args);
	}

}
