package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableAutoConfiguration
@EntityScan (basePackages={"com.example.demo.entities"})
public class Reto3Ciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Ciclo3Application.class, args);
	}

}
