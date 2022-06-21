package com.curso.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.repository.IUsuarioRepository;

@Service
public class CORREOM {
 @Autowired
 private JavaMailSender correo;
 @Autowired
 private IUsuarioRepository empleadoRepository;

 public  void  sendEmail(String  from ,String Subject,  String  content ) {
	   Iterable<Usuario>usuario=empleadoRepository.findAll();
	   for (Usuario A:usuario) {
		   SimpleMailMessage email = new  SimpleMailMessage ();
		   
		   email.setFrom(from);
		   email.setTo(A.getEmail());
		   email.setSubject(Subject);
		   email.setText(content);
		   
		   
		   correo.send(email);
		   
		   
	   }
 }
}
