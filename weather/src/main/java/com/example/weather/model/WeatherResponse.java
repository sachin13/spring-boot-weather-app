package com.example.weather.model;

import lombok.Data;

@Data
public class WeatherResponse {
	
	private Main main;
	private String name;
	
	
	@Data
	public static class Main{
		public double getTemp() {
			return temp;
		}
		public void setTemp(double temp) {
			this.temp = temp;
		}
		public double getHumidity() {
			return humidity;
		}
		public void setHumidity(double humidity) {
			this.humidity = humidity;
		}
		private double temp;
		private double humidity;
		
	}


	public Main getMain() {
		return main;
	}


	public void setMain(Main main) {
		this.main = main;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}






}
