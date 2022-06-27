package com.felipe.demo.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int Doc_Usuario;
	private String TipoDoc;
	private String Nombres;
	private String Apellidos;
	private String FechaNacimiento;
	private int celular;
	private String correo;
	private String contrasena;
	private String Ciudad;
	private String Direccion;
	private String Estado;
	
	@ManyToOne
	@JoinColumn(name = "Id_rol")
	private Rol rol;
		
	@OneToMany(mappedBy = "usuario")
	private List<Bahia> bahiaLista;
	
	@OneToMany(mappedBy = "usuario")
	private List<Correspondencia> corresLista;
	
	@OneToMany(mappedBy = "usuario")
	private List<Egresos> egresosLista;
	
	@OneToMany(mappedBy = "usuario")
	private List<Ingresos> ingresosLista;
	
	@OneToMany(mappedBy = "usuario")
	private List<Novedad> novedadLista;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pago> pagoLista;
	
	@OneToMany(mappedBy = "usuario")
	private List<Vehiculo> vehiculoLista;
	
	@OneToMany(mappedBy = "usuario")
	private List<Parqueadero> parqueaderoLista;
	
	@OneToMany(mappedBy = "usuario")
	private List<Solicitudes> solicitudesLista;

	public Usuario() {
		super();
	}

	public Usuario(int doc_Usuario, String tipoDoc, String nombres, String apellidos, String fechaNacimiento,
			int celular, String correo, String contrasena, String ciudad, String direccion, String estado, Rol rol,
			List<Bahia> bahiaLista, List<Correspondencia> corresLista, List<Egresos> egresosLista,
			List<Ingresos> ingresosLista, List<Novedad> novedadLista, List<Pago> pagoLista,
			List<Vehiculo> vehiculoLista, List<Parqueadero> parqueaderoLista, List<Solicitudes> solicitudesLista) {
		super();
		Doc_Usuario = doc_Usuario;
		TipoDoc = tipoDoc;
		Nombres = nombres;
		Apellidos = apellidos;
		FechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.correo = correo;
		this.contrasena = contrasena;
		Ciudad = ciudad;
		Direccion = direccion;
		Estado = estado;
		this.rol = rol;
		this.bahiaLista = bahiaLista;
		this.corresLista = corresLista;
		this.egresosLista = egresosLista;
		this.ingresosLista = ingresosLista;
		this.novedadLista = novedadLista;
		this.pagoLista = pagoLista;
		this.vehiculoLista = vehiculoLista;
		this.parqueaderoLista = parqueaderoLista;
		this.solicitudesLista = solicitudesLista;
	}

	public int getDoc_Usuario() {
		return Doc_Usuario;
	}

	public void setDoc_Usuario(int doc_Usuario) {
		Doc_Usuario = doc_Usuario;
	}

	public String getTipoDoc() {
		return TipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		TipoDoc = tipoDoc;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Bahia> getBahiaLista() {
		return bahiaLista;
	}

	public void setBahiaLista(List<Bahia> bahiaLista) {
		this.bahiaLista = bahiaLista;
	}

	public List<Correspondencia> getCorresLista() {
		return corresLista;
	}

	public void setCorresLista(List<Correspondencia> corresLista) {
		this.corresLista = corresLista;
	}

	public List<Egresos> getEgresosLista() {
		return egresosLista;
	}

	public void setEgresosLista(List<Egresos> egresosLista) {
		this.egresosLista = egresosLista;
	}

	public List<Ingresos> getIngresosLista() {
		return ingresosLista;
	}

	public void setIngresosLista(List<Ingresos> ingresosLista) {
		this.ingresosLista = ingresosLista;
	}

	public List<Novedad> getNovedadLista() {
		return novedadLista;
	}

	public void setNovedadLista(List<Novedad> novedadLista) {
		this.novedadLista = novedadLista;
	}

	public List<Pago> getPagoLista() {
		return pagoLista;
	}

	public void setPagoLista(List<Pago> pagoLista) {
		this.pagoLista = pagoLista;
	}

	public List<Vehiculo> getVehiculoLista() {
		return vehiculoLista;
	}

	public void setVehiculoLista(List<Vehiculo> vehiculoLista) {
		this.vehiculoLista = vehiculoLista;
	}

	public List<Parqueadero> getParqueaderoLista() {
		return parqueaderoLista;
	}

	public void setParqueaderoLista(List<Parqueadero> parqueaderoLista) {
		this.parqueaderoLista = parqueaderoLista;
	}

	public List<Solicitudes> getSolicitudesLista() {
		return solicitudesLista;
	}

	public void setSolicitudesLista(List<Solicitudes> solicitudesLista) {
		this.solicitudesLista = solicitudesLista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
