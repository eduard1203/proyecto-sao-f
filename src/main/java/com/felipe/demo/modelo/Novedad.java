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
@Table(name = "Novedad")
public class Novedad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_novedad;
	private String Fecha;
	private String Hora;
	private String Novedad;
	private String Estado;
	
	@ManyToOne
	@JoinColumn(name = "doc_usuario")
	private Usuario usuario;

	public Novedad() {
		super();
	}

	public Novedad(int id_novedad, String fecha, String hora, String novedad, String estado, Usuario usuario) {
		super();
		Id_novedad = id_novedad;
		Fecha = fecha;
		Hora = hora;
		Novedad = novedad;
		Estado = estado;
		this.usuario = usuario;
	}

	public int getId_novedad() {
		return Id_novedad;
	}

	public void setId_novedad(int id_novedad) {
		Id_novedad = id_novedad;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getNovedad() {
		return Novedad;
	}

	public void setNovedad(String novedad) {
		Novedad = novedad;
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
