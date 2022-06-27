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

import com.felipe.demo.interfaceService.IpagoService;
import com.felipe.demo.interfaces.IPago;
import com.felipe.demo.modelo.Pago;

@Controller
@RequestMapping
public class ControladorPago {
	
	@Autowired
	private IpagoService servicee;
	
	@Autowired
	private IPago iPago;
	
	private int pag;
	private int adm;
	private int rec;
	
	@GetMapping("/pagos")
	public String list(Model model) {
		List<Pago>pago=servicee.Listar();
		model.addAttribute("pago", pago);
		pag = iPago.pag();
		model.addAttribute("pag", pag);
		adm = iPago.adm();
		model.addAttribute("adm", adm);
		rec = iPago.rec();
		model.addAttribute("rec", rec);
		return "/Residente/pagos";
	}
	
	@GetMapping("/newpago")
	public String agregar(Model model) {
		model.addAttribute("pago",new Pago());
		return "/Residente/agregarPagos";
	}
	
	@PostMapping("/savePago")
	public String save(@Validated Pago p, Model model) {
		servicee.save(p);
		return "redirect:/pagos";
	}
	
	@GetMapping("/editarpago/{Id_pago}")
	public String editar( @PathVariable int Id_pago, Model model) {
		Optional<Pago>pago=servicee.ListarId(Id_pago);
		model.addAttribute("pago", pago);
		return "/Residente/agregarPagos";
	}
	
	@RequestMapping("/estadopago")
	public String Delete(@RequestParam(name = "Id_pago", defaultValue = "0") Integer Id_pago,Model model) {
		Pago pag = iPago.findById(Id_pago).orElse(null);
		if(pag.getEstado().equals("habilitado")) {
			pag.setEstado("deshabilitado");
			iPago.save(pag);
		}else if(pag.getEstado().equals("deshabilitado")) {
			pag.setEstado("habilitado");
			iPago.save(pag);
		}
		return "redirect:/pagos";
	}

	@GetMapping("/Residente")
	public String Residente() {
		return "/dashboardResidente";
	}
	
	@GetMapping("/reportesGraficos")
	public String reportesGraficos(){
		return "/guarda/reportesGraficos";
	}
	

}
