package com.felipe.demo.jasper.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.felipe.demo.modelo.reportes.ReporteIngresosDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteIngresosServiceAPI {
	
	ReporteIngresosDTO obtenerReporteIngresos(Map<String, Object> params) throws JRException, IOException, SQLException;
}
