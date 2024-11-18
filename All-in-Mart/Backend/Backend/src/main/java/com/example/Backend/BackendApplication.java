package com.example.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(BackendApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace(); // Prints the stack trace to the console
		}
	}

}