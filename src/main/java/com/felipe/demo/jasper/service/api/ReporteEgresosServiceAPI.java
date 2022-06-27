package com.felipe.demo.jasper.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.felipe.demo.modelo.reportes.ReporteEgresosDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteEgresosServiceAPI {
	
	ReporteEgresosDTO obtenerReporteEgresos(Map<String, Object> params) throws JRException, IOException, SQLException;

}
