package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IingresovehiculosService;
import com.felipe.demo.interfaces.IIngresovehiculo;
import com.felipe.demo.modelo.Ingreso_vehiculos;

@Service
public class IngresovehiculoService implements IingresovehiculosService {

	@Autowired
	private IIngresovehiculo dete;
	
	@Override
	public List<Ingreso_vehiculos> Listar() {
		// TODO Auto-generated method stub
		return (List<Ingreso_vehiculos>) dete.findAll();
	}

	@Override
	public Optional<Ingreso_vehiculos> ListarId(int Id_vehingreso) {
		// TODO Auto-generated method stub
		return dete.findById(Id_vehingreso);
	}

	@Override
	public int save(Ingreso_vehiculos iv) {
		int res=0;
		Ingreso_vehiculos ingreso_vehiculo=dete.save(iv);
		if(!ingreso_vehiculo.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int Id_vehingreso) {
		dete.deleteById(Id_vehingreso);
		
	}

}
