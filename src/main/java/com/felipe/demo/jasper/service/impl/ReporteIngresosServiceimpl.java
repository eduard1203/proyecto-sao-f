/**
 * 
 */
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
import com.felipe.demo.jasper.service.api.ReporteIngresosServiceAPI;
import com.felipe.demo.modelo.reportes.ReporteIngresosDTO;

import net.sf.jasperreports.engine.JRException;

/**
 * @author felipe
 *
 */
@Service
public class ReporteIngresosServiceimpl implements ReporteIngresosServiceAPI {

	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;

	@Override
	public ReporteIngresosDTO obtenerReporteIngresos(Map<String, Object> params)
			throws JRException, IOException, SQLException {

		String fileName = "reporte_de_ingresos";
		ReporteIngresosDTO dto = new ReporteIngresosDTO();
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
