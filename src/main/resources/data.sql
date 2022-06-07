INSERT INTO COUNTRY(id, code, name) VALUES
  (1, 'MY', 'Malaysia'),
  (2, 'SG', 'Singapore');

INSERT INTO CITY (id, country_id, code, name, coord_lon, coord_lat, timezone, cod, type, message, sunrise, sunset) VALUES
  (1, 1, 'JB', 'Johor', 0.0, 0.0, 'GMT+8', 200, 1, 0.0101, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP()),
  (2, 1, 'KL', 'Kuala Lumpur', 0.0, 0.0, 'GMT+8', 200, 1, 0.0101, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP()), 
  (3, 2, 'SG', 'Singapore', 0.0, 0.0, 'GMT+8', 200, 1, 0.0101, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

INSERT INTO WEATHER_BASIC_INFO 
(id, city_id, date, feeling, pressure, humidity, temp_min, temp_max, temp_avg, temp_night, temp_evening, temp_morning, sea_level, ground_level, visibility,
  wind_speed, wind_degree, wind_direction_cd, cloudiness_val, cloudiness_name, rain_1h, rain_3h, snow_1h, snow_3h, precipitation) VALUES
(1, 1, current_date(), 'Happy Day', 1000, 80, 28, 33, 31, 28, 31, 31, 20, 20, 80,
  50, 50, 'UP', 20, 'cloudy', 'Y', 'Y', 'N', 'N', 'A'),
(2, 2, current_date(), 'Happy Day', 1000, 80, 28, 33, 31, 28, 31, 31, 20, 20, 80,
  50, 50, 'UP', 20, 'cloudy', 'Y', 'Y', 'N', 'N', 'A'),
(3, 3, current_date(), 'Happy Day', 1000, 80, 28, 33, 31, 28, 31, 31, 20, 20, 80,
  50, 50, 'UP', 20, 'cloudy', 'Y', 'Y', 'N', 'N', 'A');
  
INSERT INTO WEATHER_BREAKDOWN_DETAILS 
(id, weather_id, date, breakdown_time, main, description, icon) VALUES
  (1, 1, current_date(), '0000', '0', 'Midnight 12am', 'Weather1'),
  (2, 1, current_date(), '0200', '0', 'Midnight 2am rain', 'Weather2'),
  (3, 2, current_date(), '0000', '0', 'Midnight', 'Weather1'), 
  (4, 3, current_date(), '0000', '0', 'Midnight', 'Weather1');