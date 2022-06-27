package com.felipe.demo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visitantes")
public class Visitante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisitante;
	

	@Column(name = "nombresApellidos")
	private String nombresApellidos;

	@Column(name = "cedula")
	private String cedula;

	@Column(name = "celular")
	private String celular;

	@Column(name = "correo")
	private String correo;

	
	public Visitante() {
		super();
	}

	public Visitante(int idVisitante, String nombresApellidos, String cedula, String celular, String correo) {
		super();
		this.idVisitante = idVisitante;
		this.nombresApellidos = nombresApellidos;
		this.cedula = cedula;
		this.celular = celular;
		this.correo = correo;
	}

	public int getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}	
}
