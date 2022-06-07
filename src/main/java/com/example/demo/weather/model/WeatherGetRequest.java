package com.example.demo.weather.model;

import javax.validation.constraints.NotNull;
import org.springdoc.api.annotations.ParameterObject;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;


@ParameterObject
@Getter
@Setter
public class WeatherGetRequest {

	@Parameter(required = true)
	@NotNull
	private String country;
	
	@Parameter(required = true)
	@NotNull
	private String city;
}
