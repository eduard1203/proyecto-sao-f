package com.felipe.demo.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.modelo.Vehiculo;

@Repository
public interface Ivehiculo extends CrudRepository<Vehiculo, Integer> {
	
	@Query(value = "SELECT COUNT(vehiculo.`id`) FROM vehiculo WHERE estado='habilitado'", nativeQuery = true)
	public int vehi();
	
	@Query(value = "SELECT COUNT(id) FROM vehiculo WHERE marca != 'mazda' AND marca != 'renault' "
			+ "AND marca != 'ford' AND marca != 'toyota'\r\n"
			+ "AND marca != 'chevbrolet' AND estado='habilitado'", nativeQuery = true)
	public int moto();
	
	@Query(value = "SELECT COUNT(id) FROM vehiculo WHERE marca != 'pulsar' AND marca != 'boxer' "
			+ "AND marca != 'suzuki'  AND estado='habilitado'", nativeQuery = true)
	public int carro();
}
