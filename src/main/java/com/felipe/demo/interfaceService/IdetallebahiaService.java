package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Detalle_bahia;

public interface IdetallebahiaService {
	
	public List<Detalle_bahia>Listar();
	public Optional<Detalle_bahia>ListarId(int Id_Detalle_Bahia);
	public int save(Detalle_bahia db);
	public void delete(int Id_Detalle_Bahia);


}
