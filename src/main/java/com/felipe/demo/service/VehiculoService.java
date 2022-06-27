package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IvehiculoService;
import com.felipe.demo.interfaces.Iusuario;
import com.felipe.demo.interfaces.Ivehiculo;
import com.felipe.demo.modelo.Vehiculo;


@Service
public class VehiculoService implements IvehiculoService {

	@Autowired
	private Ivehiculo data;
	
	@Autowired
	Ivehiculo ivehiculo;
	
	@Autowired
	Iusuario iusuario;
	
	@Override
	public List<Vehiculo> Listar() {
		
		return (List<Vehiculo>)data.findAll();
	}

	@Override
	public Optional<Vehiculo> ListarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int save(Vehiculo v) {
		int res=0;
		Vehiculo vehiculo=data.save(v);
		if (!vehiculo.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		
		data.deleteById(id);
		
	}

	@Override
	public List<Vehiculo> saveALL(List<Vehiculo> listVehiculo) {
		
		return (List<Vehiculo>) this.ivehiculo.saveAll(listVehiculo);
	}

}
