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

import com.felipe.demo.interfaceService.IingresovehiculosService;
import com.felipe.demo.interfaces.IIngresovehiculo;
import com.felipe.demo.modelo.Ingreso_vehiculos;

@Controller
@RequestMapping
public class ControladorIngresoVehiculo {
	
	@Autowired
	private IingresovehiculosService servit;
	
	@Autowired
	private IIngresovehiculo iIngresovehiculo;
	
	
	@GetMapping("/ingreso_vehiculo")
	public String list(Model mode) {
		List<Ingreso_vehiculos>ingreso_vehiculos=servit.Listar();
		mode.addAttribute("ingreso_vehiculos", ingreso_vehiculos);
		return "/guarda/ingreso_vehiculo";
	}
			
	@GetMapping("/newingresovehiculo")
	public String agregar(Model model) {
		model.addAttribute("ingreso_vehiculos" ,new Ingreso_vehiculos());
		return "/guarda/agregarIngresoVehiculo";
	}

	@PostMapping("/saveingresovehiculo")
	public String save(@Validated Ingreso_vehiculos iv, Model model) {
		servit.save(iv);
		return "redirect:/ingreso_vehiculo";
	}
	
	@GetMapping("/editaringresovehiculo/{Id_vehingreso}")
	public String editar(@PathVariable int Id_vehingreso, Model model) {
		Optional<Ingreso_vehiculos>ingreso_vehiculos=servit.ListarId(Id_vehingreso);
		model.addAttribute("ingreso_vehiculos", ingreso_vehiculos);
		return "/guarda/agregarIngresoVehiculo";
	}
	
	@RequestMapping("/estadoingresoVehiculo")
	public String Delete(@RequestParam(name = "Id_vehingreso", defaultValue = "0") Integer Id_vehingreso,Model model) {
		Ingreso_vehiculos iv = iIngresovehiculo.findById(Id_vehingreso).orElse(null);
		if(iv.getEstado().equals("habilitado")) {
			iv.setEstado("deshabilitado");
			iIngresovehiculo.save(iv);
		}else if(iv.getEstado().equals("deshabilitado")) {
			iv.setEstado("habilitado");
			iIngresovehiculo.save(iv);
		}
		return "redirect:/ingreso_vehiculo";
	}

}
