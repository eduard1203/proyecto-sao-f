package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Alquiler;

public interface Ialquiler {
	
	public List<Alquiler>listar();
	public Optional<Alquiler>listarId(int id_alquiler);
	public int save(Alquiler e);
	public void delete(int id_alquiler);
}
