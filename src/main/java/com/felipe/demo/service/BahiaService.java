package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IbahiaService;
import com.felipe.demo.interfaces.Ibahia;
import com.felipe.demo.modelo.Bahia;

@Service
public class BahiaService implements IbahiaService {

	@Autowired
	private Ibahia dato;
	
	@Override
	public List<Bahia> Listar() {
		// TODO Auto-generated method stub
		return (List<Bahia>) dato.findAll();
	}

	@Override
	public Optional<Bahia> ListarId(int Id_bahia) {
		// TODO Auto-generated method stub
		return dato.findById(Id_bahia);
	}

	@Override
	public int save(Bahia b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int Id_bahia) {
		// TODO Auto-generated method stub
		
	}

}
