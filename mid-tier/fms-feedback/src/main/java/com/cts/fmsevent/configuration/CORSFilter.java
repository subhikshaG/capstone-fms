package com.cts.fmsevent.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSFilter implements WebMvcConfigurer {
	private static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class);

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		LOGGER.info("Cors START");
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
		LOGGER.info("Cors END");
	}
}
