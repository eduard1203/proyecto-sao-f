package com.felipe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IusuarioService;
import com.felipe.demo.modelo.Usuario;

@Service
public class SendMailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private IusuarioService isu;
	
	public void sendMail(String from, String subject, String body) {
		List<Usuario>usuario=isu.Listar();
		for(Usuario u: usuario) {
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			
			mailMessage.setFrom(from);
			mailMessage.setTo(u.getCorreo());
			mailMessage.setSubject(subject);
			mailMessage.setText(body);
			
			javaMailSender.send(mailMessage);
			
		}
	}
}
