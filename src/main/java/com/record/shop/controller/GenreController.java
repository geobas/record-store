package com.record.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.cache.annotation.CacheResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class GenreController {
	
	@RequestMapping(value = "genres", method = RequestMethod.GET)
	@CacheResult
	public ArrayList<Map<String, String>> list() {
		
		ArrayList<Map<String, String>> genres = new ArrayList<Map<String, String>>();	
		
		Map<String, String> genre1 = new HashMap<String, String>();
		Map<String, String> genre2 = new HashMap<String, String>();
		Map<String, String> genre3 = new HashMap<String, String>();
		Map<String, String> genre4 = new HashMap<String, String>();
		
		genre1.put("id", "1");
		genre1.put("name", "Heavy Metal");
		genres.add(genre1);
		
		genre2.put("id", "2");
		genre2.put("name", "Power Metal");
		genres.add(genre2);

		genre3.put("id", "3");
		genre3.put("name", "Thrash Metal");	
		genres.add(genre3);
		
		genre4.put("id", "4");
		genre4.put("name", "Death Metal");	
		genres.add(genre4);
		
		return genres;
	}
}
