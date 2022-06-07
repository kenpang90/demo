package com.example.demo.weather.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.weather.mapper.WeatherMapper;
import com.example.demo.weather.model.WeatherBreakDownDetails;
import com.example.demo.weather.model.WeatherDetails;
import com.example.demo.weather.model.WeatherGetResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class WeatherService {

	private final WeatherMapper weatherMapper;
	
	
	public WeatherGetResponse getWeather(String country, String city) {
		WeatherGetResponse response = null;	
		if (weatherMapper.validateCountryAndCity(country, city) == 0) {
			// for this short test, only return null value, if wanted to return exception, can throw an exception and handle it in restadvisor
			return response;
			
		}
		
		WeatherDetails weatherDetails = weatherMapper.getWeather(country, city);
		
		if (weatherDetails != null) {
			List<WeatherBreakDownDetails> weatherBreakdownDetails = weatherMapper.getWeatherBreakdownList(1);
			
			response = WeatherGetResponse.builder()
					.city(city)
					.country(country)
					.date(weatherDetails.getDate())
					.feeling(weatherDetails.getFeeling())
					
					.pressure(weatherDetails.getPressure())
					.humidity(weatherDetails.getHumidity())
					
					// database should only stored 1 format for the temperature (Example, celcies)
					// the convertTemperature is used to cater if the user wanted other unit 
					.tempMin(convertTemperature("Celsius", weatherDetails.getTempMin(), "Kelvin"))
					.tempMax(convertTemperature("Celsius", weatherDetails.getTempMax(), "Kelvin"))
					.tempAvg(convertTemperature("Celsius", weatherDetails.getTempAvg(), "Kelvin"))
					.tempNight(convertTemperature("Celsius", weatherDetails.getTempNight(), "Kelvin"))
					.tempEvening(convertTemperature("Celsius", weatherDetails.getTempEvening(), "Kelvin"))
					.tempMorning(convertTemperature("Celsius", weatherDetails.getTempMorning(), "Kelvin"))
					
					.seaLevel(weatherDetails.getSeaLevel())
					.groundLevel(weatherDetails.getGroundLevel())
					.visibility(weatherDetails.getVisibility())
					.windSpeed(weatherDetails.getWindSpeed())
					.windDegree(weatherDetails.getWindDegree())
					.windDirectionCd(weatherDetails.getWindDirectionCd())
					.cloudinessVal(weatherDetails.getCloudinessVal())
					.cloudinessName(weatherDetails.getCloudinessName())
					.rain1h(weatherDetails.getRain1h())
					.rain3h(weatherDetails.getRain3h())
					.snow1h(weatherDetails.getSnow1h())
					.snow3h(weatherDetails.getSnow3h())
					.precipitation(weatherDetails.getPrecipitation())
					.details(weatherBreakdownDetails)
					.build();
			
		}
		
		return response;
	}
	
	

	// Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private BigDecimal convertTemperature(String unitFrom, BigDecimal temperatureFrom, String unitTo) {
		return temperatureFrom;
	}
	
	// Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
	private int convertWind(String unitFrom, int windFrom, String unitTo) {
		return windFrom;
	}
	
	
}
