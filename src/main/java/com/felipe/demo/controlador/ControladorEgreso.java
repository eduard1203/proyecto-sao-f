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

import com.felipe.demo.interfaceService.IegresoSerevice;
import com.felipe.demo.interfaces.IEgreso;
import com.felipe.demo.modelo.Egresos;

@Controller
@RequestMapping
public class ControladorEgreso {
	
	@Autowired
	private IegresoSerevice serv;
	
	@Autowired IEgreso iEgreso;
	
	@GetMapping("/egresos")
	public String listar(Model model) {
		List<Egresos>egresos=serv.Listar();
		model.addAttribute("egresos", egresos);
		return "/administradora/egresos";
	}
	
	@GetMapping("/newegreso")
	public String agregar(Model model) {
		model.addAttribute("egresos", new Egresos());
		return "/administradora/agregarEgreso";   
	}
	
	@PostMapping("/saveegreso")
	public String save(@Validated Egresos e, Model model) {
		serv.save(e);
		return "redirect:/egresos";
	}
	
	@GetMapping("/editaregreso/{Id_Egreso}")
	public String editar( @PathVariable int Id_Egreso, Model model) {
		Optional<Egresos>egresos=serv.ListarId(Id_Egreso);
		model.addAttribute("egresos", egresos);
		return "/administradora/agregarEgreso";
	}
	
	@RequestMapping("/estadoEgreso")
	public String Delete(@RequestParam(name = "Id_Egreso", defaultValue = "0") Integer Id_Egreso,Model model) {
		Egresos e = iEgreso.findById(Id_Egreso).orElse(null);
		if(e.getEstado().equals("habilitado")) {
			e.setEstado("deshabilitado");
			iEgreso.save(e);
		}else if(e.getEstado().equals("deshabilitado")) {
			e.setEstado("habilitado");
			iEgreso.save(e);
		}
		return "redirect:/egresos";
	}
}
	
