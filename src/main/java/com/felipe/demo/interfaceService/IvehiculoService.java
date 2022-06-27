package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Vehiculo;

public interface IvehiculoService {
	
	public List<Vehiculo>Listar();
	public Optional<Vehiculo>ListarId(int id);
	public int save(Vehiculo v);
	public void delete(int id);
	public List<Vehiculo> saveALL(List<Vehiculo> listVehiculo);
}
