package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IpagoService;
import com.felipe.demo.interfaces.IPago;
import com.felipe.demo.modelo.Pago;

@Service
public class PagoService implements IpagoService {
	
	@Autowired
	private IPago doto;

	@Override
	public List<Pago> Listar() {
		return (List<Pago>) doto.findAll();
	}

	@Override
	public Optional<Pago> ListarId(int Id_pago) {
		return doto.findById(Id_pago);
	}

	@Override
	public int save(Pago p) {
		int res=0;
		Pago pago=doto.save(p);
		if(!pago.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int Id_pago) {
		doto.deleteById(Id_pago);
		
	}
	

}
