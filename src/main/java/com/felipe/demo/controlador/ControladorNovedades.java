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

import com.felipe.demo.interfaceService.InovedadService;
import com.felipe.demo.interfaces.INovedad;
import com.felipe.demo.modelo.Novedad;

@Controller
@RequestMapping
public class ControladorNovedades {
	
	@Autowired
	private InovedadService serc;
	
	@Autowired
	private INovedad iNovedad;
	
	@GetMapping("/registro_novedad")
	public String listar(Model model) {
		List<Novedad>novedad=serc.Listar();
		model.addAttribute("novedad", novedad);
		return "/guarda/registro_novedad";
	}
	
	@GetMapping("/newnovedad")
	public String agregar(Model model) {
		model.addAttribute("novedad", new Novedad());
		return "/guarda/agregarNovedad";   
	}
	
	@PostMapping("/savenovedad")
	public String save(@Validated Novedad n, Model model) {
		serc.save(n);
		return "redirect:/registro_novedad";
	}
	
	@GetMapping("/editarnovedad/{Id_novedad}")
	public String editar( @PathVariable int Id_novedad, Model model) {
		Optional<Novedad>novedad=serc.ListarId(Id_novedad);
		model.addAttribute("novedad", novedad);
		return "/guarda/agregarNovedad";
	}
	
	@RequestMapping("/estadoNovedad")
	public String Delete(@RequestParam(name = "Id_novedad", defaultValue = "0") Integer Id_novedad,Model model) {
		Novedad n = iNovedad.findById(Id_novedad).orElse(null);
		if(n.getEstado().equals("habilitado")) {
			n.setEstado("deshabilitado");
			iNovedad.save(n);
		}else if(n.getEstado().equals("deshabilitado")) {
			n.setEstado("habilitado");
			iNovedad.save(n);
		}
		return "redirect:/registro_novedad";
	}
	
	
	@GetMapping("/guarda")
	public String guarda() {		
		return "dashboardguarda";		
	}
}
