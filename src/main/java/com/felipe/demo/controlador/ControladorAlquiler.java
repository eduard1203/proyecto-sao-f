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

import com.felipe.demo.interfaceService.Ialquiler;
import com.felipe.demo.interfaces.IAlquiler;
import com.felipe.demo.modelo.Alquiler;

@Controller
@RequestMapping
public class ControladorAlquiler {
	
	@Autowired
	private Ialquiler servicio; 
	
	@Autowired
	private IAlquiler alquiler;
	
	@GetMapping("/alquiler")
	public String listar(Model model) {
		List<Alquiler>alquiler=servicio.listar();
		model.addAttribute("alquiler", alquiler);
		return "/administradora/alquiler";
	}
	
	@GetMapping("/newalquiler")
	public String agregar(Model model) {
		model.addAttribute("alquiler", new Alquiler());
		return "/administradora/agregarAlquiler";
	}
	
	@PostMapping("/savealquiler")
	public String save(@Validated Alquiler a, Model model) {
		servicio.save(a);
		return "redirect:/alquiler";
	}
	
	@GetMapping("/editaralquiler/{id_alquiler}")
	public String editar(Model model, @PathVariable int id_alquiler) {
		Optional<Alquiler>alquiler=servicio.listarId(id_alquiler);
		model.addAttribute("alquiler", alquiler);
		return "/administradora/agregarAlquiler";
	}
	
	@RequestMapping("/estadoAlquiler")
	public String Delete(@RequestParam(name = "id_alquiler", defaultValue = "0") Integer id_alquiler,Model model) {
		Alquiler e = alquiler.findById(id_alquiler).orElse(null);
		if(e.getEstado().equals("habilitado")) {
			e.setEstado("deshabilitado");
			alquiler.save(e);
		}else if(e.getEstado().equals("deshabilitado")) {
			e.setEstado("habilitado");
			alquiler.save(e);
		}
		return "redirect:/alquiler";
	}
}
