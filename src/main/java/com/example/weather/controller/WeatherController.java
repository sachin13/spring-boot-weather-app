package com.example.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.weather.model.WeatherResponse;
import com.example.weather.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.weather.repository.HistoryRepository;
@Controller
public class WeatherController {
	
	
	private final WeatherService service;
	
	public WeatherController(WeatherService service) {
		
		this.service=service;
	}
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	@PostMapping("/weather")
	public String getWeather(@RequestParam String city,Model model)
	{
		WeatherResponse response =service.getWeather(city);
		
		if (response == null || response.getMain() == null) {
		    model.addAttribute("error", "Unable to fetch weather. Check city name or API key.");
		    return "error";
		}
		
		double temp = response.getMain().getTemp();
	    String icon = temp >= 30 ? "☀️" : (temp >= 20 ? "🌤️" : "❄️");

		
		model.addAttribute("city",response.getName());
		
		model.addAttribute("temp", response.getMain().getTemp());
		model.addAttribute("humidity", response.getMain().getHumidity());
		model.addAttribute("icon",icon);
		
		return "weather";
	}
	
	
	@Autowired
	private HistoryRepository historyrepo;
	@GetMapping("/history")
	public String showHistory(Model model) {
		
		model.addAttribute("history",historyrepo.findAll());
		return "history";
	}
	
	
	@GetMapping("/history/delete/{id}")
	public String deleteHistory(@PathVariable Long id,
	                            @RequestParam(defaultValue = "0") int page,
	                            @RequestParam(required = false) String filterCity) {
		historyrepo.deleteById(id);
	    return "redirect:/history?page=" + page + (filterCity != null ? "&city=" + filterCity : "");
	}
	
	@GetMapping("/history/clear")
	public String clearHistory() {  
		historyrepo.deleteAll();
		return "redirect:/history";
	}

}
