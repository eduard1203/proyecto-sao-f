package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IingresosService;
import com.felipe.demo.interfaces.Iingresos;
import com.felipe.demo.modelo.Ingresos;

@Service
public class IngresosService implements IingresosService {

	@Autowired
	private Iingresos dataa;
	
	@Override
	public List<Ingresos> Listar() {
		return (List<Ingresos>)dataa.findAll();
	}

	@Override
	public Optional<Ingresos> ListarId(int id_ingreso) {
		return dataa.findById(id_ingreso);
	}

	@Override
	public int save(Ingresos i) {
		int res = 0;
		Ingresos ingreso=dataa.save(i);
		if(!ingreso.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id_ingreso) {
		
		dataa.deleteById(id_ingreso);
		
	}
	
}
