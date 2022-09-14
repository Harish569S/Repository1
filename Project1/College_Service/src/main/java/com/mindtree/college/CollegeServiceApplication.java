package com.mindtree.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CollegeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeServiceApplication.class, args);
	}
	@Bean
	@LoadBalanced
	RestTemplate restTemp() {
		return new  RestTemplate();
	}

}
