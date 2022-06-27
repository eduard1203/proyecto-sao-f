package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Novedad;

public interface InovedadService {
	
	public List<Novedad>Listar();
	public Optional<Novedad>ListarId(int Id_novedad);
	public int save(Novedad n);
	public void delete(int Id_novedad);

}
