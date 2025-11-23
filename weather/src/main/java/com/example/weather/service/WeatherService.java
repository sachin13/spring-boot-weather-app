package com.example.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.example.weather.model.WeatherResponse;

import org.springframework.beans.factory.annotation.Value;


@Service
public class WeatherService {
	
	@Value("${WEATHER_API_KEY}")
	private String apikey;

	
	@Value("${WEATHER_API_URL}")
	private String apiUrl;

	


	
	private final RestTemplate restTemplate=new RestTemplate();
	
	
	public WeatherResponse getWeather(String city) {
		
		String url=apiUrl +"?q="+city +"&appid="+apikey+"&units=metric";
		
		WeatherResponse response=restTemplate.getForObject(url, WeatherResponse.class);
		
		if(response!=null && response.getMain()!=null)
		{
			//saveHistory(response);
		}
		
		return response;
	}
	
	/*
	 * private void saveHistory(WeatherResponse response) {
	 * 
	 * WeatherHistory h=new WeatherHistory(); h.setCity(response.getName());
	 * h.setTemperature(response.getMain().getHumidity());
	 * h.setHumidity(response.getMain().getHumidity());
	 * h.setDateTime(LocalDateTime.now());
	 * 
	 * historyRepo.save(h);
	 * 
	 * 
	 * }
	 */
	

}



