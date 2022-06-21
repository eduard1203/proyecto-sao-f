package com.curso.ecommerce.service;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.repository.IUsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}
	@Override
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);		
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	@Override
	public void update(Usuario usuario) {
		usuarioRepository.save(usuario);		
	}
	@Override
	public Optional<Usuario> get(Integer id) {
		return usuarioRepository.findById(id);
	}
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>)usuarioRepository.findAll();
	}
	@Override
	public int saveUsu(Usuario usu) {
		int res=0;
		Usuario  usuarios= usuarioRepository.save(usu);
		if (!usuarios.equals(null)) {
			res=1;
		}
		return res;
	}
	@Override
	public Optional<Usuario> ListarId(int id) {
		
		return usuarioRepository.findById(id);
	}
	public boolean saveDataFromUploadfile(MultipartFile file1) {
		boolean isFlag =false;
		String extension  = FilenameUtils.getExtension(file1.getOriginalFilename());
		if(extension.equalsIgnoreCase("json")) {
		 isFlag = readDataFromJson(file1);
		}else if (extension.equalsIgnoreCase("csv")) {
			 isFlag = readDataFromCsv(file1);
		}else if (extension.equalsIgnoreCase("xls")|| extension.equalsIgnoreCase("xls")) {
			 isFlag = readDataFromExcel(file1);
		}
		return isFlag;
	}
	private boolean readDataFromExcel(MultipartFile file1) {
	   Workbook workbook =  getWorkbook(file1);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		rows.next();
		while(rows.hasNext()) {
			Row row = rows.next();
			Usuario Usuario = new Usuario();
			if(row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
				Usuario.setId(row.getCell(0).getStringCellValue());
			}
			if(row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
				Usuario.setLastName(row.getCell(0).getStringCellValue());
			}
			Usuario.setFileType(FilenameUtils.getExtension(file1.getOriginalFilename()));
			usuarioRepository.save(Usuario);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return false;
	}
	private Workbook getWorkbook(MultipartFile file1) {
	 Workbook workbook =  null;
	 String extension  = FilenameUtils.getExtension(file1.getOriginalFilename());
	 try {
		 if(extension.equalsIgnoreCase("xls")) {
			 workbook = new XSSFWorkbook(file1.getInputStream());
			 
		 }else 	 if(extension.equalsIgnoreCase("xls")){
			 workbook =  new HSSFWorkbook(file1.getInputStream());
			 
		 }
		 
	 }catch (Exception e) {
		 e.printStackTrace();

	}
		
		
		
		
		
		
		return workbook;
	}
	private boolean readDataFromCsv(MultipartFile file1) {
	try {
		InputStreamReader reader = new InputStreamReader(file1.getInputStream());
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		List<String[]> rows = csvReader.readAll();
		for(String[] row : rows) {
			usuarioRepository.save(new Usuario(row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8],FilenameUtils.getExtension(file1.getOriginalFilename())));
		}
		return  true;
		
	}catch (Exception e) {
		return false;
	}
		
		
	}
	private boolean readDataFromJson(MultipartFile file1) {
	        try {
	        	InputStream inputStream = file1.getInputStream();
	        	
	        	
	        	
	        ObjectMapper mapper = new  ObjectMapper();
	        List<Usuario>usuarios = Arrays.asList(mapper.readValue(inputStream, Usuario[].class));
	        if(usuarios!=null && usuarios.size()>0) {
	        	for(Usuario usuario : usuarios) {
	        		usuario.setFileType(FilenameUtils.getExtension(file1.getOriginalFilename()));
	        		
	        	}
	        }
	        return  true;	
	        	
	        	
	        }catch (Exception e) {
	        	return false;
	        	
	        }
	        
	}
	@Override
	public boolean saveDataFromUploadfile(CommonsMultipartFile file1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean saveDataFromUploadfile(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
}
