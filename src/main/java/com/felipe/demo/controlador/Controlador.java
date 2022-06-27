package com.felipe.demo.controlador;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.felipe.demo.interfaceService.IvehiculoService;
import com.felipe.demo.interfaces.Ivehiculo;
import com.felipe.demo.modelo.Vehiculo;
import com.felipe.demo.service.UploadFileService;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IvehiculoService service;
	
	@Autowired 
	private Ivehiculo ivehiculo;
	
	@Autowired
	IvehiculoService ivehiculoService;
	
	@Autowired 
	UploadFileService uploadFileService;
	
	private int vehi;
	private int moto;
	private int carro;
	
	@GetMapping("/registro_vehiculos")
	public String listar(Model model) {		
		List<Vehiculo>vehiculos=service.Listar();
		model.addAttribute("vehiculos", vehiculos);
		vehi = ivehiculo.vehi();
		model.addAttribute("vehi", vehi);
		moto = ivehiculo.moto();
		model.addAttribute("moto", moto);
		carro = ivehiculo.carro();
		model.addAttribute("carro", carro);
		return "/administradora/registro_vehiculos";
		
	}
		
	@GetMapping("/administradora")
	public String administradora() {		
		return "dashboardadministradora";		
	}
				
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("vehiculo", new Vehiculo());
		return "/administradora/agregarVehiculo";
	}
	
	@PostMapping("/save")
	public String save(@Validated Vehiculo v, Model model) {
		service.save(v);
		return "redirect:/registro_vehiculos";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Vehiculo>vehiculo=service.ListarId(id);
		model.addAttribute("vehiculo", vehiculo);
		return "/administradora/agregarVehiculo";
	}
	
	@RequestMapping("/estadoVehiculo")
	public String Delete(@RequestParam(name = "id", defaultValue = "0") Integer id,Model model) {
		Vehiculo v = ivehiculo.findById(id).orElse(null);
		if(v.getEstado().equals("habilitado")) {
			v.setEstado("deshabilitado");
			ivehiculo.save(v);
		}else if(v.getEstado().equals("deshabilitado")) {
			v.setEstado("habilitado");
			ivehiculo.save(v);
		}
		return "redirect:/registro_vehiculos";
	}
	
	@RequestMapping("/uploadFileVehiculo")
	public String saveFileExcelVehiculo(MultipartFile file, Model model) throws IOException {
		this.uploadFileService.guardarFileVehiculo(file);
		return "/administradora/registro_vehiculos";
	}
		
}
