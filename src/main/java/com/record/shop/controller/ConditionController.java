package com.record.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.cache.annotation.CacheResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class ConditionController {
	
	@RequestMapping(value = "conditions", method = RequestMethod.GET)
	@CacheResult
	public ArrayList<HashMap<String, String>> list() {
		
		ArrayList<HashMap<String, String>> conditions = new ArrayList<>();	
		
		HashMap<String, String> condition1 = new HashMap<>();
		HashMap<String, String> condition2 = new HashMap<>();
		HashMap<String, String> condition3 = new HashMap<>();
		HashMap<String, String> condition4 = new HashMap<>();
		
		condition1.put("id", "1");
		condition1.put("name", "New");
		conditions.add(condition1);
		
		condition2.put("id", "2");
		condition2.put("name", "Used");
		conditions.add(condition2);

		condition3.put("id", "3");
		condition3.put("name", "Used - Like New");	
		conditions.add(condition3);
		
		condition4.put("id", "4");
		condition4.put("name", "Used - Very Good");	
		conditions.add(condition4);
		
		return conditions;
	}
}
