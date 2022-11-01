package com.klef.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.klef"})
public class Lib3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lib3Application.class, args);
		System.out.println("Server Started");
	}

}
