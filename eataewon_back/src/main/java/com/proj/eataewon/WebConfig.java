package com.proj.eataewon;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		// WebMvcConfigurer.super.addCorsMappings(registry);
		
		// registry.addMapping("/**").allowedOrigins("http://localhost:8090");
		registry.addMapping("/**").allowedOrigins("*");
	}
	
}
