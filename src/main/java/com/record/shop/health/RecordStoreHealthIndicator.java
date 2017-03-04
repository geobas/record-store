package com.record.shop.health;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RecordStoreHealthIndicator implements HealthIndicator {
	
	@Value("${uploadfilepath}")
	private String uploadfilepath;	
	
	@Override
	public Health health() {
		File directory = new File(uploadfilepath);
		if ( !directory.canWrite() ) 
			return Health.down().withDetail("Error message", "img/ directory is not writable.").build();
		
		return Health.up().build();
	}	
}
