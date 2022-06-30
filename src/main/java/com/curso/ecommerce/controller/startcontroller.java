package com.curso.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.curso.ecommerce.clases.DeveloperTutorialRepository ;
import com.curso.ecommerce.clases.DeveloperTutorial ;

@Controller
@RequestMapping

public class startcontroller {
	
	
	@Autowired
	private DeveloperTutorialRepository DeveloperTutorialRepository;
	
	private int  us;

@GetMapping("/cargamasiva")
    public String cargamasiva() {
	
		
        return "carga_masiva";
    }

}