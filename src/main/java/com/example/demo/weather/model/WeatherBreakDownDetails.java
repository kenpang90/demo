package com.example.demo.weather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherBreakDownDetails {

	private String breakdownTime;
	private String main;
	private String description;
	private String icon;
	
}
