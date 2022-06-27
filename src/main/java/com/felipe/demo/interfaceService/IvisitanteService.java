package com.felipe.demo.interfaceService;

import java.util.List;

import com.felipe.demo.modelo.Visitante;

public interface IvisitanteService {
	
	public List<Visitante>listar();
	public List<Visitante> saveALL(List<Visitante> listVisitante);

}
