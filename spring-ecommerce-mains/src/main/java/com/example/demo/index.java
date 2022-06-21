package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class index {
	
	
	@GetMapping("/")
public String indeX() {

	return"index";
}
}
