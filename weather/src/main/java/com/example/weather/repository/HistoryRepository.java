package com.example.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.weather.model.WeatherHistory;
import java.util.List;
import java.util.ArrayList;


public interface HistoryRepository extends JpaRepository<WeatherHistory,Long>  {

	List<WeatherHistory> findByCityContainingIgnoreCase(String city);
	
}
