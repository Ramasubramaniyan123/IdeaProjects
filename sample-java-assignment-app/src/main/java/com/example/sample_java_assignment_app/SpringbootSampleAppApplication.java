package com.example.sample_java_assignment_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootSampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSampleAppApplication.class, args);
	}
	@GetMapping("/login")
	public String login(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Please input your credentials for login...");
	}

	@GetMapping("/register")
	public String register(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Please follow registration process...");
	}

}
