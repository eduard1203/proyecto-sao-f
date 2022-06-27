package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Solicitudes;

@Repository
public interface Isolicitud extends CrudRepository<Solicitudes, Integer> {

}
