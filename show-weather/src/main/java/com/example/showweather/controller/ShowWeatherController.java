package com.example.showweather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.showweather.delegate.WeatherServiceDelegate;

@RestController
public class ShowWeatherController {

    @Autowired
    WeatherServiceDelegate weatherServiceDelegate;

    @RequestMapping(value = "/getWeatherDetailsWithCity/{city}", method = RequestMethod.GET)
    public String getWeatherWithCity(@PathVariable String city) {
        System.out.println("Going to call weather service with city to get data!");
        return weatherServiceDelegate.callWeatherServiceWithCityAndGetData(city);
    }

    @RequestMapping(value = "/getWeatherDetailsWithZipCode/{zipCode}", method = RequestMethod.GET)
    public String getWeatherWithZipCode(@PathVariable String zipCode) {
        System.out.println("Going to call weather service with zipCode to get data!");
        return weatherServiceDelegate.callWeatherServiceWithZipCodeAndGetData(zipCode);
    }


}