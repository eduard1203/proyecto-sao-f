package com.curso.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.ecommerce.service.CORREOM;

@Controller
public class correoControl {
	@Autowired
	private CORREOM gmail;
	
	@GetMapping("/correos")
	public String sendEmail(@RequestParam("titulo")String Subject,@RequestParam("cuerpo")String content ) {
		
		
		gmail.sendEmail("migueleduxs@gmail.com", Subject , content);
		return "inicio";
	}
	

}
