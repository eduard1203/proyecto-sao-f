package com.felipe.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.felipe.demo.service.SendMailService;

@Controller
public class ContoladorSendMail {
	
	@Autowired
	private SendMailService sendMailService;
		
	@GetMapping("/sendMail")
	public String sendMail(@RequestParam("asunto")String subject, @RequestParam("mensaje")String body) {
		sendMailService.sendMail("mesuney47@gmail.com", subject, body);
		return "dashboardadministradora";
	}

}
