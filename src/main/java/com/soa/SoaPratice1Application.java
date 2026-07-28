package com.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SoaPratice1Application {

	public static void main(String[] args) {
		SpringApplication.run(SoaPratice1Application.class, args);
		System.out.println("Project started Running");
	}

    @Bean
	   public RestTemplate restTemplate() {
			return new RestTemplate();
		}
}
