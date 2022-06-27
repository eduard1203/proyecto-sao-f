package com.felipe.demo.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Ingresos;

@Repository
public interface Iingresos extends CrudRepository<Ingresos, Integer> {
	
	@Query(value = "SELECT SUM(monto) AS total FROM ingresos WHERE estado='habilitado'", nativeQuery = true)
	public int totalIngre();
	
	@Query(value = "SELECT COUNT(usuario.`doc_usuario`) FROM usuario WHERE usuario.`id_rol`=3", nativeQuery = true)
	public int residentes();
	
	@Query(value = "SELECT AVG(monto) FROM ingresos WHERE estado='habilitado'", nativeQuery = true)
	public int prom();
}
