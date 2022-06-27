package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Ingresos;

public interface IingresosService {
	
	public List<Ingresos>Listar();
	public Optional<Ingresos>ListarId(int id_ingreso);
	public int save(Ingresos i);
	public void delete(int id_ingreso);
}
