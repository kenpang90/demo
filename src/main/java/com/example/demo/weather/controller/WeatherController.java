package com.example.demo.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.weather.model.WeatherGetResponse;
import com.example.demo.weather.service.WeatherService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping(value= "/api/weather")
public class WeatherController {

	private final WeatherService weatherService;

	@GetMapping(value= "/v1")
	public BaseResponse<WeatherGetResponse> getTest(@RequestHeader("apiKey") String apiKey, @RequestParam(name = "country") String country, @RequestParam(name = "city") String city) {
		return BaseResponse.success(weatherService.getWeather(country, city));
	}
	
}
