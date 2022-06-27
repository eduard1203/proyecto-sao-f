package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IusuarioService;
import com.felipe.demo.interfaces.Iusuario;
import com.felipe.demo.modelo.Usuario;

@Service
public class UsuarioService implements IusuarioService {

	@Autowired
	private Iusuario dat;
	
	@Override
	public List<Usuario> Listar() {
		return (List<Usuario>)dat.findAll();
	}

	@Override
	public Optional<Usuario> ListarId(int Doc_Usuario) {
		
		return dat.findById(Doc_Usuario);
	}

	@Override
	public int save(Usuario u) {		
		int res =0;
		Usuario usuario=dat.save(u);
		if(!usuario.equals(null)) {
			res=1;
		}
		
		return res;
	}

	@Override
	public void delete(int Doc_Usuario) {
		dat.deleteById(Doc_Usuario);
		
	}
}
