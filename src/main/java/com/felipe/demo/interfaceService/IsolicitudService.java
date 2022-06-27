package com.felipe.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.felipe.demo.modelo.Solicitudes;

public interface IsolicitudService {
	
	public List<Solicitudes>Listar();
	public Optional<Solicitudes>ListarId(int Id_solicitud);
	public int save(Solicitudes s);
	public void delete(int Id_solicitud);

}
