package com.felipe.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Bahia;

@Repository
public interface Ibahia extends CrudRepository<Bahia, Integer> {

}
