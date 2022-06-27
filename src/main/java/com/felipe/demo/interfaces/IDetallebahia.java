package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Detalle_bahia;

@Repository
public interface IDetallebahia extends CrudRepository<Detalle_bahia, Integer> {

}
