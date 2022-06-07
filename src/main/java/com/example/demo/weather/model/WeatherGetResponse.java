package com.example.demo.weather.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeatherGetResponse {


	private String country;
	
	private String city;
	
	private Date date;
	private String feeling;
	private int pressure;
	private int humidity;
	private BigDecimal tempMin;
	private BigDecimal tempMax;
	private BigDecimal tempAvg;
	private BigDecimal tempNight;
	private BigDecimal tempEvening;
	private BigDecimal tempMorning;
	
	private int seaLevel;
	private int groundLevel;
	private int visibility;
	
	private BigDecimal windSpeed;
	private int windDegree;
	private String windDirectionCd;

	private int cloudinessVal;
	private String cloudinessName;
	
	private String rain1h;
	private String rain3h;
	private String snow1h;
	private String snow3h;
	private String precipitation;
	
	private List<WeatherBreakDownDetails> details;

	  
}
