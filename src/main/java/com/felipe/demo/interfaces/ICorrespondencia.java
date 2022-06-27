package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Correspondencia;

@Repository
public interface ICorrespondencia extends CrudRepository<Correspondencia, Integer> {

}
