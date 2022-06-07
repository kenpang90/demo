package com.example.demo.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.security.mapper.SecurityMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Component
@Log4j2
public class SecurityFilter extends OncePerRequestFilter{

	private final SecurityMapper securityMapper;
	private int limitCount = 5;
	public static List<String> validApiKeyList = Arrays.asList("1", "2", "3", "4", "5");
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestPath = request.getServletPath();
		if (requestPath.startsWith("/api")) {
			final String apiKey = request.getHeader("APIKEY");

			if (apiKey == null || !validApiKeyList.contains(apiKey)) {
	            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	            response.getWriter().write("missing api key");
	            return;
			}else {
				int count = securityMapper.getHittingCount(apiKey, requestPath);
				if (count >= limitCount) {
		            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		            response.getWriter().write("rate limit");
		            return;
				}
			}

			securityMapper.insertAPIKey(apiKey, requestPath);
		}
		filterChain.doFilter(request, response);
	}

	
}
