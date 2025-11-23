package com.example.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weather.model.WeatherHistory;
import com.example.weather.model.WeatherResponse;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import com.example.weather.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class WeatherService {
	
	@Value("${weather.api.key}")
	private String apikey;
	
	@Value("${weather.api.url}")
	private String apiUrl;
	
 
	
	private final RestTemplate restTemplate=new RestTemplate();
	
	
	public WeatherResponse getWeather(String city) {
		
		String url=apiUrl +"?q="+city +"&appid="+apikey+"&units=metric";
		
		WeatherResponse response=restTemplate.getForObject(url, WeatherResponse.class);
		
		if(response!=null && response.getMain()!=null)
		{
			
		}
		
		return response;
	}
	
	
	

}



