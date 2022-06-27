package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IegresoSerevice;
import com.felipe.demo.interfaces.IEgreso;
import com.felipe.demo.modelo.Egresos;

@Service
public class EgresoService implements IegresoSerevice {

	@Autowired
	private IEgreso dat;
	
	@Override
	public List<Egresos> Listar() {
		return (List<Egresos>)dat.findAll();
	}

	@Override
	public Optional<Egresos> ListarId(int Id_Egreso) {
		return dat.findById(Id_Egreso);
	}

	@Override
	public int save(Egresos e) {
		int res=0;
		Egresos egresos=dat.save(e);
		if(!egresos.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int Id_Egreso) {
		dat.deleteById(Id_Egreso);
		
	}
	


}
