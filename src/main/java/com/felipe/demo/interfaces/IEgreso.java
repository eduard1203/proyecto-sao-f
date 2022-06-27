package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Egresos;

@Repository
public interface IEgreso extends CrudRepository<Egresos, Integer>{

}
