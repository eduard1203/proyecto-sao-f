package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class indexs{
	
	
	@GetMapping("/")
public String indeX() {

	return"index";
}
}