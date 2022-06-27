package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Ingreso_vehiculos;

@Repository
public interface IIngresovehiculo extends CrudRepository<Ingreso_vehiculos, Integer> {

}
