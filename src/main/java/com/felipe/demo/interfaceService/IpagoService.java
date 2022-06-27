package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Pago;

public interface IpagoService {
	
	public List<Pago>Listar();
	public Optional<Pago>ListarId(int Id_pago);
	public int save(Pago p);
	public void delete(int Id_pago);

}
