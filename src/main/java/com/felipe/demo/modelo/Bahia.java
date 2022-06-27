package com.felipe.demo.modelo;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bahia")
public class Bahia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_bahia;
	private String Disponibilidad;
	
	@ManyToOne
	@JoinColumn(name = "doc_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "bahia")
	private List<Detalle_bahia> detalleBahiaLista;

	public Bahia() {
		super();
	}

	public Bahia(int id_bahia, String disponibilidad, Usuario usuario, List<Detalle_bahia> detalleBahiaLista) {
		super();
		Id_bahia = id_bahia;
		Disponibilidad = disponibilidad;
		this.usuario = usuario;
		this.detalleBahiaLista = detalleBahiaLista;
	}

	public int getId_bahia() {
		return Id_bahia;
	}

	public void setId_bahia(int id_bahia) {
		Id_bahia = id_bahia;
	}

	public String getDisponibilidad() {
		return Disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		Disponibilidad = disponibilidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Detalle_bahia> getDetalleBahiaLista() {
		return detalleBahiaLista;
	}

	public void setDetalleBahiaLista(List<Detalle_bahia> detalleBahiaLista) {
		this.detalleBahiaLista = detalleBahiaLista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
