package com.felipe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IvisitanteService;
import com.felipe.demo.interfaces.IVisitante;
import com.felipe.demo.modelo.Visitante;

@Service
public class VisitanteService implements IvisitanteService  {

	@Autowired
	private IVisitante dul;
	
	@Autowired
	IVisitante iVisitante;

	@Override
	public List<Visitante> listar() {
		return (List<Visitante>)dul.findAll();
	}

	@Override
	public List<Visitante> saveALL(List<Visitante> listVisitante) {
		return (List<Visitante>) this.iVisitante.saveAll(listVisitante);
	}


}
