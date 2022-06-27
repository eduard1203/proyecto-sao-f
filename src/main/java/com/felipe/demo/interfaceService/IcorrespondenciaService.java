package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Correspondencia;

public interface IcorrespondenciaService {
	
	public List<Correspondencia>Listar();
	public Optional<Correspondencia>ListarId(int Id_correspondencia);
	public int save(Correspondencia c);
	public void delete(int Id_correspondencia);

}
