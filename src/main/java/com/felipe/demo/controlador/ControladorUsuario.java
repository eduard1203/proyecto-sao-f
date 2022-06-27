package com.felipe.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.felipe.demo.interfaceService.IusuarioService;
import com.felipe.demo.interfaces.Iusuario;
import com.felipe.demo.modelo.Usuario;


@Controller
@RequestMapping
public class ControladorUsuario {
	
	@Autowired
	private IusuarioService ser;
	
	@Autowired
	private Iusuario iusuario;
	
	@GetMapping("/registros_usuarios")
	public String listar(Model model) {
		List<Usuario>usuarios=ser.Listar();
		model.addAttribute("usuarios", usuarios);
		return "administradora/registros_usuarios";
	}
	
	@GetMapping("/agregarUsuario")
	public String agregarUsuario() {		
		return "/administradora/agregarUsuario";	
	}
	
	@GetMapping("/newusuario")
	public String agregar(Model model) {
		model.addAttribute("usuarios",new Usuario());
		return "/administradora/agregarUsuario";
	}
	
	@PostMapping("/saveusuario")
	public String save( @Validated Usuario u, Model model) {
		ser.save(u);
		return "redirect:/registros_usuarios";
	}
		
	@GetMapping("/editarusuario/{Doc_Usuario}")
	public String editarusuario(@PathVariable int Doc_Usuario, Model model) {
		Optional<Usuario>usuarios=ser.ListarId(Doc_Usuario);
		model.addAttribute("usuarios", usuarios);
		return "/administradora/agregarUsuario";
	}
	
	@RequestMapping("/estadoUsuario")
	public String Delete(@RequestParam(name = "Doc_Usuario", defaultValue = "0") Integer Doc_Usuario,Model model) {
		Usuario u = iusuario.findById(Doc_Usuario).orElse(null);
		if(u.getEstado().equals("habilitado")) {
			u.setEstado("deshabilitado");
			iusuario.save(u);
		}else if(u.getEstado().equals("deshabilitado")) {
			u.setEstado("habilitado");
			iusuario.save(u);
		}
		return "redirect:/registros_usuarios";
	}
	
}
