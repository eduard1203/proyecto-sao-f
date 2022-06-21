package com.curso.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.IUsuarioService;
import com.curso.ecommerce.service.ProductoService;
import com.curso.ecommerce.service.UploadFileService;
import com.curso.ecommerce.service.UsuarioServiceImpl;

@Controller
@RequestMapping("/productos2")
public class ProductoController2 {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController2.class);
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private UploadFileService upload;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "productos2/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos2/create";
	}
	
	@PostMapping("/saves")
	public String save(Producto producto, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
		LOGGER.info("Este es el objeto producto {}",producto);
		
		
		Usuario u= usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString() )).get();
		producto.setUsuario(u);	
		
		//imagen
		if (producto.getId()==null) { // cuando se crea un producto
			String nombreImagen= upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}else {
			
		}
		
		productoService.save(producto);
		return "redirect:/productos2";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto= new Producto();
		Optional<Producto> optionalProducto=productoService.get(id);
		producto= optionalProducto.get();
		
		LOGGER.info("Producto buscado: {}",producto);
		model.addAttribute("producto", producto);
		
		return "productos2/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile file ) throws IOException {
		Producto p= new Producto();
		p=productoService.get(producto.getId()).get();
		
		if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem
			
			producto.setImagen(p.getImagen());
		}else {// cuando se edita tbn la imagen			
			//eliminar cuando no sea la imagen por defecto
			if (!p.getImagen().equals("default.jpg")) {
				upload.deleteImage(p.getImagen());
			}
			String nombreImagen= upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}
		producto.setUsuario(p.getUsuario());
		productoService.update(producto);		
		return "redirect:/productos2";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Producto p = new Producto();
		p=productoService.get(id).get();
		
		//eliminar cuando no sea la imagen por defecto
		if (!p.getImagen().equals("default.jpg")) {
			upload.deleteImage(p.getImagen());
		}
		
		productoService.delete(id);
		return "redirect:/productos2";
	}
	
	
}
