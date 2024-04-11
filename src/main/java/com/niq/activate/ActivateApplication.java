package com.niq.activate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ActivateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivateApplication.class, args);
	}

}
