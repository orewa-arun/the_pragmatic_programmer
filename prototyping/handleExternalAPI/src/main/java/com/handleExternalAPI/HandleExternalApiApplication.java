package com.handleExternalAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HandleExternalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandleExternalApiApplication.class, args);
	}

}
