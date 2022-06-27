package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IcorrespondenciaService;
import com.felipe.demo.interfaces.ICorrespondencia;
import com.felipe.demo.modelo.Correspondencia;

@Service
public class CorrespondenciaService implements IcorrespondenciaService {
	
	@Autowired
	private ICorrespondencia dutu;

	@Override
	public List<Correspondencia> Listar() {
		// TODO Auto-generated method stub
		return (List<Correspondencia>) dutu.findAll();
	}

	@Override
	public Optional<Correspondencia> ListarId(int Id_correspondencia) {
		// TODO Auto-generated method stub
		return dutu.findById(Id_correspondencia);
	}

	@Override
	public int save(Correspondencia c) {
		int res=0;
		Correspondencia correspondencia=dutu.save(c);
		if(!correspondencia.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int Id_correspondencia) {
		dutu.deleteById(Id_correspondencia);
		
	}
 
}
