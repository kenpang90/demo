package com.example.demo.weather.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.weather.model.WeatherBreakDownDetails;
import com.example.demo.weather.model.WeatherDetails;

@Mapper
@Repository
public interface WeatherMapper {

	int validateCountryAndCity(String country, String city);
	
	WeatherDetails getWeather(String country, String city);
	
	List<WeatherBreakDownDetails> getWeatherBreakdownList(int weatherId);
}
