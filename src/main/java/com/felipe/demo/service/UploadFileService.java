package com.felipe.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.felipe.demo.modelo.Visitante;

@Service
public class UploadFileService {
	@Autowired 
	VisitanteService visitanteService;
	List<Visitante> listVisitante=new ArrayList<>();
	public void guardarFileVehiculo(MultipartFile file)throws IOException{
		System.out.println("fileC" + file.getOriginalFilename());
		InputStream externalFile = file.getInputStream();
		XSSFWorkbook libro = new XSSFWorkbook(externalFile);
		XSSFSheet hoja = libro.getSheetAt(0);
		Iterator<Row> filas = hoja.iterator();
		Iterator<Cell> celdas;
		Row row;
		Cell cell;
		filas.next();
		while(filas.hasNext()) {
			Visitante visitante = new Visitante();
			row=filas.next();
			celdas=row.cellIterator();
			while(celdas.hasNext()) {
				cell=celdas.next();
				int index=cell.getColumnIndex();
				
				switch(index) {
					case 0:{
						break;
					}
					case 1:{
						visitante.setNombresApellidos(cell.toString());
					}
					case 2:{
						visitante.setCedula(cell.toString());
					}
					case 3:{
						visitante.setCelular(cell.toString());
					}
					case 4:{
						visitante.setCorreo(cell.toString());
					}
					
					default:break;
				}
			}
			this.listVisitante.add(visitante);
		}
		libro.close();
		this.visitanteService.saveALL(listVisitante);
	}

}
