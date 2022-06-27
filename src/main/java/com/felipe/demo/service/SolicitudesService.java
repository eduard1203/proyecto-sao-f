package com.felipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.interfaceService.IsolicitudService;
import com.felipe.demo.interfaces.Isolicitud;
import com.felipe.demo.modelo.Solicitudes;

@Service
public class SolicitudesService implements IsolicitudService {

	@Autowired
	private Isolicitud dote;
	
	@Override
	public List<Solicitudes> Listar() {
		return (List<Solicitudes>) dote.findAll();
	}

	@Override
	public Optional<Solicitudes> ListarId(int Id_solicitud) {
		return dote.findById(Id_solicitud);
	}

	@Override
	public int save(Solicitudes s) {
		int res=0;
		Solicitudes solicitudes=dote.save(s);
		if(!solicitudes.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int Id_solicitud) {
		dote.deleteById(Id_solicitud);
		
	}

}
