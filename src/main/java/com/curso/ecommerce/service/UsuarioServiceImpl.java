package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}
	@Override
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);		
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	@Override
	public void update(Usuario usuario) {
		usuarioRepository.save(usuario);		
	}
	@Override
	public Optional<Usuario> get(Integer id) {
		return usuarioRepository.findById(id);
	}
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	@Override
	public int saveUsu(Usuario usu) {
		int res=0;
		Usuario  usuarios= usuarioRepository.save(usu);
		if (!usuarios.equals(null)) {
			res=1;
		}
		return res;
	}
	@Override
	public Optional<Usuario> ListarId(int id) {
		
		return usuarioRepository.findById(id);
	}
}
