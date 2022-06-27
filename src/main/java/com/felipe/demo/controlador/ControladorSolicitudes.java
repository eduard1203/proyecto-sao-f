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

import com.felipe.demo.interfaceService.IsolicitudService;
import com.felipe.demo.interfaces.Isolicitud;
import com.felipe.demo.modelo.Solicitudes;

@Controller
@RequestMapping
public class ControladorSolicitudes {
	
	@Autowired
	private IsolicitudService se;
	
	@Autowired
	private Isolicitud isolicitud;
	
	@GetMapping("/solicitudes")
	public String list(Model mode) {
		List<Solicitudes>solicitudes=se.Listar();
		mode.addAttribute("solicitudes", solicitudes);
		return "/Residente/solicitudes";
	}
			
	@GetMapping("/newsolicitud")
	public String agregar(Model model) {
		model.addAttribute("solicitudes" ,new Solicitudes());
		return "/Residente/agregarSolicitud";
	}

	@PostMapping("/savesolicitud")
	public String save(@Validated Solicitudes s, Model model) {
		se.save(s);
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/editarsolicitud/{Id_solicitud}")
	public String editar(@PathVariable int Id_solicitud, Model model) {
		Optional<Solicitudes>solicitudes=se.ListarId(Id_solicitud);
		model.addAttribute("solicitudes", solicitudes);
		return "/Residente/agregarSolicitud";
	}
	
	@RequestMapping("/estadosolicitud")
	public String Delete(@RequestParam(name = "Id_solicitud", defaultValue = "0") Integer Id_solicitud,Model model) {
		Solicitudes soli = isolicitud.findById(Id_solicitud).orElse(null);
		if(soli.getEstado().equals("habilitado")) {
			soli.setEstado("deshabilitado");
			isolicitud.save(soli);
		}else if(soli.getEstado().equals("deshabilitado")) {
			soli.setEstado("habilitado");
			isolicitud.save(soli);
		}
		return "redirect:/solicitudes";
	}

}
