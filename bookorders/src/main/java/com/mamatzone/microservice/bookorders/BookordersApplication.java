package com.mamatzone.microservice.bookorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BookordersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookordersApplication.class, args);
	}

}
