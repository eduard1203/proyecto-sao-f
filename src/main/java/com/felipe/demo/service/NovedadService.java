package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.InovedadService;
import com.felipe.demo.interfaces.INovedad;
import com.felipe.demo.modelo.Novedad;

@Service
public class NovedadService implements InovedadService {
	
	@Autowired
	private INovedad dito;

	@Override
	public List<Novedad> Listar() {

		return (List<Novedad>) dito.findAll();
	}

	@Override
	public Optional<Novedad> ListarId(int Id_novedad) {
		return dito.findById(Id_novedad);
	}

	@Override
	public int save(Novedad n) {
		int res=0;
		Novedad novedad=dito.save(n);
		if(!novedad.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int Id_novedad) {
		dito.deleteById(Id_novedad);
		
	}

}
