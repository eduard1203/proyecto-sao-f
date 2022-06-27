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

import com.felipe.demo.interfaceService.IingresosService;
import com.felipe.demo.interfaces.Iingresos;
import com.felipe.demo.modelo.Ingresos;


@Controller
@RequestMapping
public class ControladorIngresos {
	
	@Autowired
	private IingresosService servic;
	
	@Autowired
	private Iingresos iingresos;

	private int total;
	private int resi;
	private int prom;
		
	@GetMapping("/ingresos")
	public String list(Model mode) {
		List<Ingresos>ingresos=servic.Listar();
		mode.addAttribute("ingresos", ingresos);
		total = iingresos.totalIngre();
		mode.addAttribute("total", total);
		resi = iingresos.residentes();
		mode.addAttribute("resi", resi);
		prom = iingresos.prom();
		mode.addAttribute("prom", prom);
		return "/administradora/ingresos";
	}
	
	
	@GetMapping("/newingreso")
	public String agregar(Model model) {
		model.addAttribute("ingresos" ,new Ingresos());
		return "/administradora/agregarIngreso";
	}

	@PostMapping("/saveingreso")
	public String save(@Validated Ingresos i, Model model) {
		servic.save(i);
		return "redirect:/ingresos";
	}
	
	@GetMapping("/editaringreso/{id_ingreso}")
	public String editar(@PathVariable int id_ingreso, Model model) {
		Optional<Ingresos>ingresos=servic.ListarId(id_ingreso);
		model.addAttribute("ingresos", ingresos);
		return "/administradora/agregarIngreso";
	}
	
	@RequestMapping("/estadoIngreso")
	public String Delete(@RequestParam(name = "id_ingreso", defaultValue = "0") Integer id_ingreso,Model model) {
		Ingresos i = iingresos.findById(id_ingreso).orElse(null);
		if(i.getEstado().equals("habilitado")) {
			i.setEstado("deshabilitado");
			iingresos.save(i);
		}else if(i.getEstado().equals("deshabilitado")) {
			i.setEstado("habilitado");
			iingresos.save(i);
		}
		return "redirect:/ingresos";
	}	
}
