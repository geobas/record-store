package com.record.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class ConditionController {
	
	@RequestMapping(value = "conditions", method = RequestMethod.GET)
	public ArrayList<Map<String, String>> list() {
		
		ArrayList<Map<String, String>> conditions = new ArrayList<Map<String, String>>();	
		
		Map<String, String> condition1 = new HashMap<String, String>();
		Map<String, String> condition2 = new HashMap<String, String>();
		Map<String, String> condition3 = new HashMap<String, String>();
		Map<String, String> condition4 = new HashMap<String, String>();
		
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
