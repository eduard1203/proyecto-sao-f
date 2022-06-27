package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Usuario;

public interface IusuarioService {
	
	public List<Usuario>Listar();
	public Optional<Usuario>ListarId(int Doc_Usuario);
	public int save(Usuario u);
	public void delete(int Doc_Usuario);
}
