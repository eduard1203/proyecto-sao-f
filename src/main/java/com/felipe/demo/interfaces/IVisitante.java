package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Visitante;

@Repository
public interface IVisitante extends CrudRepository<Visitante, Integer>{
	
}
