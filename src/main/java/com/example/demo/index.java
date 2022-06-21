package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class index {
	
	
	@GetMapping("https://proyecto-sao-final.herokuapp.com/")
public String indeX() {

	return"index";
}
}
