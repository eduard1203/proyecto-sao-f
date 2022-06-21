package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.model.Usuario;

public interface IUsuarioService {
	List<Usuario> findAll();
	public Optional<Usuario> get(Integer id);
	public void update(Usuario usuario);
	Optional<Usuario> findById(Integer id);
	public void delete(Integer id);
	Usuario save (Usuario usuario);
	Optional<Usuario> findByEmail(String email);
	public Optional<Usuario>ListarId(int id);
	public int saveUsu(Usuario usu);
	boolean saveDataFromUploadfile(Object object);
	boolean saveDataFromUploadfile(CommonsMultipartFile file1);

}
