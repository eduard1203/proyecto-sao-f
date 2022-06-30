package com.curso.ecommerce.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.curso.ecommerce.model.Orden;
import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.repository.IUsuarioRepository;
import com.curso.ecommerce.service.IOrdenService;
import com.curso.ecommerce.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger logger= LoggerFactory.getLogger(UsuarioController.class);
	     
	
	

	
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IOrdenService ordenService;
	
	BCryptPasswordEncoder passEncode= new BCryptPasswordEncoder();
	

	
	
	
	// /usuario/registro
	@GetMapping("/registro")
	public String create() {
		return "usuario/registro";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		logger.info("Usuario registro: {}", usuario);
		usuario.setTipo("USER");
		usuario.setPassword( passEncode.encode(usuario.getPassword()));
		usuarioService.save(usuario);		
		return "redirect:/";
	}
	
    
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Usuario  usuario= new Usuario();
		Optional<Usuario> optionalProducto=usuarioService.get(id);
		usuario= optionalProducto.get();
		
		
		
		return "administrador/edit";
	}
	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}
	@PostMapping("/update")
	public String update(Usuario usuario  ) throws IOException {
		Usuario p= new Usuario();
		p=usuarioService.get(usuario.getId()).get();
		
	
			
	
		usuarioService.update(usuario);		
		return "redirect:/administrador/usuarios";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Usuario>usuario=usuarioService.ListarId(id);
		model.addAttribute("usuario", usuario);
		return "/administrador/edit";
	}
	
	@PostMapping("/saveUsuarios")
	public String saveUsu(@Validated Usuario usu, Model model) {
		usuarioService.saveUsu(usu);
		return "redirect:/administrador/usuarios";
		
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Usuario a= new Usuario();
		a=usuarioService.get(id).get();
		
	
		usuarioService.delete(id);
		return "redirect:/productos";
	}
	
	@GetMapping("/acceder")
	public String acceder(Usuario usuario, HttpSession session) {
		logger.info("Accesos : {}", usuario);
		
		Optional<Usuario> user=usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString()));
		 
		
		if (user.isPresent()) {
			session.setAttribute("idusuario", user.get().getId());
			
			if (user.get().getTipo().equals("ADMIN")) {
				return "redirect:/administrador";
			} 
			else if (user.get().getTipo().equals("BODEGA")) {
				return "redirect:/BODEGA";
			} 
			else if (user.get().getTipo().equals("USER")) {
				return "redirect:/home";
			} 
			else  {
				return "redirect:/";
			}
		}else {
			logger.info("Usuario no existe");
		}
		
		return "redirect:/";
	}
	
	
	@GetMapping("/compras")
	public String obtenerCompras(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		
		Usuario usuario= usuarioService.findById(  Integer.parseInt(session.getAttribute("idusuario").toString()) ).get();
		List<Orden> ordenes= ordenService.findByUsuario(usuario);
		logger.info("ordenes {}", ordenes);
		
		model.addAttribute("ordenes", ordenes);
		
		return "usuario/compras";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleCompra(@PathVariable Integer id, HttpSession session, Model model) {
		logger.info("Id de la orden: {}", id);
		Optional<Orden> orden=ordenService.findById(id);
		
		model.addAttribute("detalles", orden.get().getDetalle());
		
		
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "usuario/detallecompra";
	}
	
	
	@GetMapping("/cerrar")
	public String cerrarSesion( HttpSession session ) {
		session.removeAttribute("idusuario");
		return "redirect:/index";
	}
}
