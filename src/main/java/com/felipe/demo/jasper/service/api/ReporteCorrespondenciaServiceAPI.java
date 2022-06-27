package com.felipe.demo.jasper.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.felipe.demo.modelo.reportes.ReporteCorrespondenciaDTO;
import net.sf.jasperreports.engine.JRException;

public interface ReporteCorrespondenciaServiceAPI {
	
	ReporteCorrespondenciaDTO obtenerReporteCorrespondencia(Map<String, Object> params) 
			throws JRException, IOException, SQLException;

}
