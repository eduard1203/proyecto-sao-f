package com.felipe.demo.jasper.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.felipe.demo.modelo.reportes.ReportePagosDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReportePagosServiceAPI {
	
	ReportePagosDTO obtenerReportePagos(Map<String, Object> params) throws JRException, IOException, SQLException;

}
