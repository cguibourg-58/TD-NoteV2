package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Weather;

@RestController
public class WeatherController {

	public WeatherController() {}

	private static List<Weather>  weatherList = new ArrayList<Weather>();

	private static Map<String, List<Weather>> countryDB = new HashMap<String, List<Weather>>();

	static {
		countryDB = new HashMap<String, List<Weather>>();

		List<Weather> lst = new ArrayList<Weather>();
		Weather std = new Weather("Nice","06000","Ca grele et il fait 7°C ouille !");
		lst.add(std);
		weatherList.add(std);
		std = new Weather("Marseille","13000","Il fait beau et il fait 21°C !");
		lst.add(std);
		weatherList.add(std);
		countryDB.put("France", lst);

		lst = new ArrayList<Weather>();
		std = new Weather("Londres","84410","Il pleut et il fait 16°C !");
		lst.add(std);
		weatherList.add(std);
		std = new Weather("York","89310","Du brouillard et il fait 12°C !");
		lst.add(std);
		weatherList.add(std);
		countryDB.put("Royaume-Uni", lst);

	}

	@RequestMapping(value = "/getWeatherDetailsForCountry/{countryname}", method = RequestMethod.GET)
	public List<Weather> getWeathersByCountryname(@PathVariable String countryname) {
		System.out.println("Getting Weather details for " + countryname);
		List<Weather> wList = countryDB.get(countryname);
		if (wList == null) {
			wList = new ArrayList<Weather>();
			Weather std = new Weather("Not Found", "N/A", "N/A");
			wList.add(std);
		}
		return wList;
	}

	@RequestMapping(value = "/getWeatherDetailsForCity/{city}", method = RequestMethod.GET)
	public List<Weather> getWeathersByCity(@PathVariable String city) {
		System.out.println("Getting Weather details for " + city);
		List<Weather> wList = new ArrayList<Weather>();
		for (Weather w : weatherList) {
			if(city.equalsIgnoreCase(w.getCity())) {
				wList.add(w);
			}
		}
		if (wList.size()<1) {
			Weather std = new Weather("Not Found", "N/A", "N/A");
			wList.add(std);
		}
		return wList;
	}

	@RequestMapping(value = "/getWeatherDetailsForZip_code/{zip_code}", method = RequestMethod.GET)
	public List<Weather> getWeathersByZip_code(@PathVariable String zip_code) {
		System.out.println("Getting Weather details for " + zip_code);
		List<Weather> wList = new ArrayList<Weather>();
		for (Weather w : weatherList) {
			if(zip_code.equalsIgnoreCase(w.getZip_code())) {
				wList.add(w);
			}
		}
		if (wList.size()<1) {
			Weather std = new Weather("Not Found", "N/A", "N/A");
			wList.add(std);
		}
		return wList;
	}

}
