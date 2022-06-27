package com.felipe.demo.jasper.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.demo.jasper.service.api.ReporteEgresosServiceAPI;
import com.felipe.demo.modelo.reportes.ReporteEgresosDTO;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/report")
public class ReporteEgresosController {
	
	@Autowired
	private ReporteEgresosServiceAPI reporteEgresosServiceAPI;
	@GetMapping(path = "/egresos/download")
	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		
		
		ReporteEgresosDTO dto = reporteEgresosServiceAPI.obtenerReporteEgresos(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(com.felipe.demo.jasper.Enum.TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLenght()).contentType(mediaType).body(streamResource);
	}

}
