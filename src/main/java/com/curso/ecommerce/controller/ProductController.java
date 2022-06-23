package com.curso.ecommerce.controller;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.curso.ecommerce.helpers.ExcelHelper;
import com.curso.ecommerce.model.Product;

@Controller
@RequestMapping(value = { "", "product" })
public class ProductController implements ServletContextAware {

	private ServletContext servletContext;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "/index2";
	}

	@RequestMapping(value = "process", method = RequestMethod.POST)
	public String process(@RequestParam("file") MultipartFile file) throws Exception {
		String fileName = uploadExcelFile(file);
		System.out.println("File Name: " + fileName);
		String excelPath = servletContext.getRealPath("/resources/excels/" + fileName);
		System.out.println("Excel Path: " + excelPath);
		ExcelHelper excelHelper = new ExcelHelper(excelPath);
		List<Product> products = excelHelper.readData(Product.class.getName());
		System.out.println("Product List");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Product product : products) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("Quantity: " + product.getQuantity());
			System.out.println("Status: " + product.isStatus());
			System.out.println("Date: " + simpleDateFormat.format(product.getCreationDate()));
			System.out.println("=========================");
		}
		return "/index2";
	}

	private String uploadExcelFile(MultipartFile multipartFile) {
		try {
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(servletContext.getRealPath("/resources/excels/" + multipartFile.getOriginalFilename()));
			Files.write(path, bytes);
			return multipartFile.getOriginalFilename();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}