package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Egresos;

public interface IegresoSerevice {
	
	public List<Egresos>Listar();
	public Optional<Egresos>ListarId(int Id_Egreso);
	public int save(Egresos e);
	public void delete(int Id_Egreso);

}
