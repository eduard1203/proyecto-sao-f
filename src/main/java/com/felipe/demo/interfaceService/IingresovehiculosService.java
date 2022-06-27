package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Ingreso_vehiculos;

public interface IingresovehiculosService {
	
	public List<Ingreso_vehiculos>Listar();
	public Optional<Ingreso_vehiculos>ListarId(int Id_vehingreso);
	public int save(Ingreso_vehiculos iv);
	public void delete(int Id_vehingreso);

}
