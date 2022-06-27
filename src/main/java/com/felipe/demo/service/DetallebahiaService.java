package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IdetallebahiaService;
import com.felipe.demo.interfaces.IDetallebahia;
import com.felipe.demo.modelo.Detalle_bahia;

@Service
public class DetallebahiaService implements IdetallebahiaService {

	@Autowired
	private IDetallebahia dit; 
	
	@Override
	public List<Detalle_bahia> Listar() {
		
		return (List<Detalle_bahia>) dit.findAll();
	}

	@Override
	public Optional<Detalle_bahia> ListarId(int Id_Detalle_Bahia) {
		return dit.findById(Id_Detalle_Bahia);
	}

	@Override
	public int save(Detalle_bahia db) {
		int res=0;
		Detalle_bahia detalle_bahia=dit.save(db);
		if(!detalle_bahia.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int Id_Detalle_Bahia) {
		dit.deleteById(Id_Detalle_Bahia);
		
	}
	
}
