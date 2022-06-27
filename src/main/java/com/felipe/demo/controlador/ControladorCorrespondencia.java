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

import com.felipe.demo.interfaceService.IcorrespondenciaService;
import com.felipe.demo.interfaces.ICorrespondencia;
import com.felipe.demo.modelo.Correspondencia;

@Controller
@RequestMapping

public class ControladorCorrespondencia {
	
	@Autowired
	private IcorrespondenciaService sere;
	
	@Autowired 
	private ICorrespondencia iCorrespondencia;
	
	@GetMapping("/registro_correspondencia")
	public String list(Model mode) {
		List<Correspondencia>correspondencia=sere.Listar();
		mode.addAttribute("correspondencia", correspondencia);
		return "/guarda/registro_correspondencia";
	}
			
	@GetMapping("/newcorrespondencia")
	public String agregar(Model model) {
		model.addAttribute("correspondencia" ,new Correspondencia());
		return "/guarda/agregarCorrespondencia";
	}

	@PostMapping("/savecorrespondencia")
	public String save(@Validated Correspondencia c, Model model) {
		sere.save(c);
		return "redirect:/registro_correspondencia";
	}
	
	@GetMapping("/editarcorrespondencia/{Id_correspondencia}")
	public String editar(@PathVariable int Id_correspondencia, Model model) {
		Optional<Correspondencia>correspondencia=sere.ListarId(Id_correspondencia);
		model.addAttribute("correspondencia", correspondencia);
		return "/guarda/agregarCorrespondencia";
	}
	
	@RequestMapping("/estadoCorrespondencia")
	public String Delete(@RequestParam(name = "Id_correspondencia", defaultValue = "0") Integer Id_correspondencia,Model model) {
		Correspondencia c = iCorrespondencia.findById(Id_correspondencia).orElse(null);
		if(c.getEstado().equals("habilitado")) {
			c.setEstado("deshabilitado");
			iCorrespondencia.save(c);
		}else if(c.getEstado().equals("deshabilitado")) {
			c.setEstado("habilitado");
			iCorrespondencia.save(c);
		}
		return "redirect:/registro_correspondencia";
	}
	
	
}
