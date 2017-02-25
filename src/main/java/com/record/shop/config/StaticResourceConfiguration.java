package com.record.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.record.shop.RecordStoreApplication;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + RecordStoreApplication.IMAGE_DIR);
        super.addResourceHandlers(registry);  
    }
}