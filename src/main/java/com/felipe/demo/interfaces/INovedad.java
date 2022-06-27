package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Novedad;

@Repository
public interface INovedad extends CrudRepository<Novedad, Integer> {

}
