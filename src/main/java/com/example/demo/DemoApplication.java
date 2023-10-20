package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Main application class
 */
@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.model") // Specify the package where your entities are located
public class DemoApplication {
	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}