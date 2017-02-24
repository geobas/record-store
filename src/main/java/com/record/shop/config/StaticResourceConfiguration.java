package com.record.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/images/records/**")
        .addResourceLocations("/public/images/records/")
        .setCachePeriod(0);
    }
}