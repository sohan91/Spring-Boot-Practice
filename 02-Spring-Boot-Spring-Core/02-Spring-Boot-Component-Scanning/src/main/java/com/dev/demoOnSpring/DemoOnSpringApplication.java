package com.dev.demoOnSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.dev.demoOnSpring","com.outsidescope"}
)
public class DemoOnSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOnSpringApplication.class, args);
	}

}
