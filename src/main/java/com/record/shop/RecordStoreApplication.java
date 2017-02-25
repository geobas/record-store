package com.record.shop;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class RecordStoreApplication extends SpringBootServletInitializer
{
    public static String IMAGE_DIR;
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RecordStoreApplication.class);
    }
	
    public static void main( String[] args ) throws IOException
    {
    	IMAGE_DIR = new File(".").getCanonicalPath() + "/img/";
    	SpringApplication.run(RecordStoreApplication.class, args);
    }
}