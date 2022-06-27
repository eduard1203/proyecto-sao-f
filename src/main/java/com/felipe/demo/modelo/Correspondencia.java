package com.felipe.demo.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "correspondencia")
public class Correspondencia implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_correspondencia;
	private String Fecha_Llegada;
	private String Hora_llegada;
	private String Descripcion;
	private String Estado;
	
	@ManyToOne
	@JoinColumn(name = "doc_usuario")
	private Usuario usuario;

	public Correspondencia() {
		super();
	}

	public Correspondencia(int id_correspondencia, String fecha_Llegada, String hora_llegada, String descripcion,
			String estado, Usuario usuario) {
		super();
		Id_correspondencia = id_correspondencia;
		Fecha_Llegada = fecha_Llegada;
		Hora_llegada = hora_llegada;
		Descripcion = descripcion;
		Estado = estado;
		this.usuario = usuario;
	}

	public int getId_correspondencia() {
		return Id_correspondencia;
	}

	public void setId_correspondencia(int id_correspondencia) {
		Id_correspondencia = id_correspondencia;
	}

	public String getFecha_Llegada() {
		return Fecha_Llegada;
	}

	public void setFecha_Llegada(String fecha_Llegada) {
		Fecha_Llegada = fecha_Llegada;
	}

	public String getHora_llegada() {
		return Hora_llegada;
	}

	public void setHora_llegada(String hora_llegada) {
		Hora_llegada = hora_llegada;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
