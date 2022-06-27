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
@Table(name = "parqueadero")
public class Parqueadero implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_parqueadero;
	
	@ManyToOne
	@JoinColumn(name = "doc_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "Id_vehiculo")
	private Vehiculo vehiculo;

	public Parqueadero() {
		super();
	}

	public Parqueadero(int id_parqueadero, Usuario usuario, Vehiculo vehiculo) {
		super();
		Id_parqueadero = id_parqueadero;
		this.usuario = usuario;
		this.vehiculo = vehiculo;
	}

	public int getId_parqueadero() {
		return Id_parqueadero;
	}

	public void setId_parqueadero(int id_parqueadero) {
		Id_parqueadero = id_parqueadero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	

}
