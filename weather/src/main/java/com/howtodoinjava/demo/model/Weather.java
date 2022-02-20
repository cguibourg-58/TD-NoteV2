package com.howtodoinjava.demo.model;

public class Weather {

	public Weather(String city, String zip_code, String weatherDescription) {
		super();
		this.city = city;
		this.zip_code = zip_code;
		this.weatherDescription = weatherDescription;
	}

	private String city;
	private String zip_code;
	private String weatherDescription;
	
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWeatherDescription() {
		return weatherDescription;
	}
	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	@Override
	public String toString() {
		return "Weather [city= " + city + "; zip_code= " + zip_code
				+ "; Weather: " + weatherDescription+"]";
	}
}
