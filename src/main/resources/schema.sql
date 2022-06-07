CREATE TABLE API_LIMITATION (
  api_keys VARCHAR(250),
  path VARCHAR(250),
  access TIMESTAMP(9)
);

CREATE TABLE COUNTRY (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code VARCHAR(12),
  name VARCHAR(250)
);

CREATE TABLE CITY (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  country_id INT,
  code VARCHAR(12),
  name VARCHAR(250),
  coord_lon DECIMAL(20,5),
  coord_lat DECIMAL(20,5),
  timezone VARCHAR(12),
  cod VARCHAR(12),
  type INT,
  message DECIMAL(20,5),
  sunrise TIMESTAMP(9),
  sunset TIMESTAMP(9)
);

CREATE TABLE WEATHER_BASIC_INFO (
  id INT AUTO_INCREMENT PRIMARY KEY,
  city_id INT,
  date DATE,
  feeling VARCHAR(250),
  pressure INT,
  humidity INT,
  temp_min DECIMAL(5,2),
  temp_max DECIMAL(5,2),
  temp_avg DECIMAL(5,2),
  temp_night DECIMAL(5,2),
  temp_evening DECIMAL(5,2),
  temp_morning DECIMAL(5,2),
  sea_level INT,
  ground_level INT,
  visibility INT,
  wind_speed DECIMAL(5,2),
  wind_degree INT,
  wind_direction_cd VARCHAR(12),
  cloudiness_val INT,
  cloudiness_name VARCHAR(12),
  rain_1h VARCHAR(12),
  rain_3h VARCHAR(12),
  snow_1h VARCHAR(12),
  snow_3h VARCHAR(12),
  precipitation VARCHAR(12)
);

CREATE TABLE WEATHER_BREAKDOWN_DETAILS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  weather_id INT,
  date DATE,
  breakdown_time VARCHAR(4),
  main VARCHAR(250),
  description VARCHAR(250),
  icon VARCHAR(12)
);
