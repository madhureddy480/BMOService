package com.madhukarnati.emp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Service Application
 */
@SpringBootApplication
public class BMOServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BMOServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BMOServiceApplication.class, args);
	}
}
