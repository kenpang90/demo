package com.example.demo.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SecurityMapper {
	
	void insertAPIKey(String apiKey, String path);

	int getHittingCount(String apiKey, String path);
}
