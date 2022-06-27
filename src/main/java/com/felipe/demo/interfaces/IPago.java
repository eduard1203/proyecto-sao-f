package com.felipe.demo.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Pago;

@Repository
public interface IPago extends CrudRepository<Pago, Integer> {
	
	@Query(value = "SELECT COUNT(id_pago) FROM pago WHERE estado='habilitado'", nativeQuery = true)
	public int pag();
	
	@Query(value = "SELECT COUNT(id_pago) FROM pago WHERE concepto='Administracion' "
			+ "AND estado='habilitado'", nativeQuery = true)
	public int adm();
	
	@Query(value = "SELECT COUNT(id_pago) FROM pago WHERE concepto LIKE '%recibo%' "
			+ "AND estado='habilitado'", nativeQuery = true)
	public int rec();
	
}
