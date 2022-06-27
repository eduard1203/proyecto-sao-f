package com.felipe.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.felipe.demo.interfaces.Iusuario;
import com.felipe.demo.modelo.Usuario;

@Controller
@RequestMapping
public class ControladorLogin {
	
	@Autowired
	private Iusuario usuarioservice;
		
	@GetMapping("/inicio")
	public String incio() {		
		return "inicio";		
	}
	
	@GetMapping("/Login")
	public String Login(Usuario usuario) {
		return "Login";
	}
	@PostMapping("/LoginSession")
	public String LoginSession(Usuario usuario, Model model, RedirectAttributes attribute) {
		Usuario verificar = usuarioservice.findByCorreoAndContrasena(usuario.getCorreo(), usuario.getContrasena());
		if(verificar != null) {
			if(verificar.getRol().getNom_Rol().equals("ADMINISTRADORA") && verificar.getEstado().equals("habilitado")) {
				return "dashboardadministradora";
			}else if(verificar.getRol().getNom_Rol().equals("GUARDA_SEGURIDAD") && verificar.getEstado().equals("habilitado")) {
				return "dashboardguarda";
			}else if(verificar.getRol().getNom_Rol().equals(null) || verificar.getEstado().equals("deshabilitado")) {
				attribute.addFlashAttribute("error2", "Usuario deshabilitado. Comuniquese con la administradora");
				return "redirect:/Login";
			}
			
			if(verificar.getRol().getNom_Rol().equals("RESIDENTE") && verificar.getEstado().equals("habilitado")) {
				return "dashboardResidente";
			}	
		}else {
			attribute.addFlashAttribute("error", "Contraseña o correo incorrecto");
			return "redirect:/Login";
		}
		return "redirect:/Login";
	}	
}
