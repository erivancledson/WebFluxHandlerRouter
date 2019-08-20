package com.erivan.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebFluxHandlerRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxHandlerRouterApplication.class, args);
		System.out.println("Router");
	}

}
