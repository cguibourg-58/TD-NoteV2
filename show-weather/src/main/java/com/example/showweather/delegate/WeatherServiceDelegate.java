package com.example.showweather.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceDelegate {
    @Autowired
    RestTemplate restTemplate;

    public String callWeatherServiceWithCityAndGetData(String city) {
        System.out.println("Consul Demo - Getting Weather details for " + city);
        String response = restTemplate.exchange("http://weather-service/getWeatherDetailsForCity/{city}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, city).getBody();


        System.out.println("Response Received as " + response + " -  " + new Date());

        return "City Name -  " + city + " :::  Weather Details " + response + " -  " + new Date();
    }

    public String callWeatherServiceWithZipCodeAndGetData(String zipCode) {
        System.out.println("Consul Demo - Getting Weather details for " + zipCode);
        String response = restTemplate.exchange("http://weather-service/getWeatherDetailsForZip_code/{zipCode}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, zipCode).getBody();


        System.out.println("Response Received as " + response + " -  " + new Date());

        return "Zip Code -  " + zipCode + " :::  Weather Details " + response + " -  " + new Date();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
