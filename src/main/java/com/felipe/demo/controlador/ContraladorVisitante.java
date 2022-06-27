package com.felipe.demo.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.felipe.demo.interfaceService.IvisitanteService;
import com.felipe.demo.modelo.Visitante;
import com.felipe.demo.service.UploadFileService;

@Controller
@RequestMapping
public class ContraladorVisitante {
	
	@Autowired
	UploadFileService uploadFileService;
	
	@Autowired
	private IvisitanteService iVisitante;
	
	@RequestMapping("/uploadFilevisitante")
	public String saveFileExcelVehiculo(MultipartFile file, Model model) throws IOException {
		this.uploadFileService.guardarFileVehiculo(file);
		return "/guarda/visitante";
	}
	
	@GetMapping("/visitante")
	public String listar(Model model) {
		List<Visitante>visitante=iVisitante.listar();
		model.addAttribute("visitante", visitante);
		return "/guarda/visitante";
	}


}
