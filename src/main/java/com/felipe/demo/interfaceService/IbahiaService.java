package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Bahia;

public interface IbahiaService {
	
	public List<Bahia>Listar();
	public Optional<Bahia>ListarId(int Id_bahia);
	public int save(Bahia b);
	public void delete(int Id_bahia);

}
