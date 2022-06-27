package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.Ialquiler;
import com.felipe.demo.interfaces.IAlquiler;
import com.felipe.demo.modelo.Alquiler;

@Service
public class AlquilerService implements Ialquiler {

	@Autowired
	private IAlquiler da;
	
	@Override
	public List<Alquiler> listar() {
		return (List<Alquiler>)da.findAll();
	}

	@Override
	public Optional<Alquiler> listarId(int id_alquiler) {
		return da.findById(id_alquiler);
	}

	@Override
	public int save(Alquiler a) {
		int res=0;
		Alquiler alquiler=da.save(a);
		if(!alquiler.equals(null)) {
			res=1;
		}
		
		return res;
	}

	@Override
	public void delete(int id_alquiler) {
		da.deleteById(id_alquiler);
		
	}

}
