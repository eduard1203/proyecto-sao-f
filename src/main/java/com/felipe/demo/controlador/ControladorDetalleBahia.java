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

import com.felipe.demo.interfaceService.IdetallebahiaService;
import com.felipe.demo.interfaces.IDetallebahia;
import com.felipe.demo.modelo.Detalle_bahia;

@Controller
@RequestMapping
public class ControladorDetalleBahia {
	
	@Autowired
	private IdetallebahiaService seri;
	
	@Autowired
	private IDetallebahia iDetallebahia;
	
	@GetMapping("/registro_bahia")
	public String listar(Model model) {
		List<Detalle_bahia>detalle_bahia=seri.Listar();
		model.addAttribute("detalle_bahia", detalle_bahia);
		return "/guarda/registro_bahia";
	}
	
	@GetMapping("/newdetallebahia")
	public String agregar(Model model) {
		model.addAttribute("detalle_bahia", new Detalle_bahia());
		return "/guarda/agregarBahia";   
	}
	
	@PostMapping("/savedetallebahia")
	public String save(@Validated Detalle_bahia db, Model model) {
		seri.save(db);
		return "redirect:/registro_bahia";
	}
	
	@GetMapping("/editardetallebahia/{Id_Detalle_Bahia}")
	public String editar( @PathVariable int Id_Detalle_Bahia, Model model) {
		Optional<Detalle_bahia>detalle_bahia=seri.ListarId(Id_Detalle_Bahia);
		model.addAttribute("detalle_bahia", detalle_bahia);
		return "/guarda/agregarBahia";
	}
	
	@RequestMapping("/estadobahia")
	public String Delete(@RequestParam(name = "Id_Detalle_Bahia", defaultValue = "0") Integer Id_Detalle_Bahia,Model model) {
		Detalle_bahia db = iDetallebahia.findById(Id_Detalle_Bahia).orElse(null);
		if(db.getEstado().equals("habilitado")) {
			db.setEstado("deshabilitado");
			iDetallebahia.save(db);
		}else if(db.getEstado().equals("deshabilitado")) {
			db.setEstado("habilitado");
			iDetallebahia.save(db);
		}
		return "redirect:/registro_bahia";
	}

}
