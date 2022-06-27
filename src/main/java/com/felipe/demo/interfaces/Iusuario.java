package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Usuario;

@Repository
public interface Iusuario extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByCorreoAndContrasena(String correo, String contrasena);
		
}

