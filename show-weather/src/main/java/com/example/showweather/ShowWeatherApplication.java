package com.example.showweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShowWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowWeatherApplication.class, args);
	}

}
