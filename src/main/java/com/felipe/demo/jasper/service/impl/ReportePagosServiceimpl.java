package com.felipe.demo.jasper.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.jasper.Enum.TipoReporteEnum;
import com.felipe.demo.jasper.commons.JasperReportManager;
import com.felipe.demo.jasper.service.api.ReportePagosServiceAPI;
import com.felipe.demo.modelo.reportes.ReportePagosDTO;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReportePagosServiceimpl implements ReportePagosServiceAPI {
	
	@Autowired
	private JasperReportManager reportManager;
	
	@Autowired
	private DataSource dataSource;

	@Override
	public ReportePagosDTO obtenerReportePagos(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		
		String fileName = "reporte_de_pago";
		ReportePagosDTO dto = new ReportePagosDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());
		
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLenght(bs.length);
		
		return dto;
	}

}
