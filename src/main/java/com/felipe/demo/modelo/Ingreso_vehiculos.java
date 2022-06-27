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
@Table(name = "ingreso_vehiculos")
public class Ingreso_vehiculos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_vehingreso;
	private String Fecha_ingreso;
	private String Hora_ingreso;
	private String Estado;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;

	public Ingreso_vehiculos() {
		super();
	}

	public Ingreso_vehiculos(int id_vehingreso, String fecha_ingreso, String hora_ingreso, String estado, Vehiculo vehiculo) {
		super();
		Id_vehingreso = id_vehingreso;
		Fecha_ingreso = fecha_ingreso;
		Hora_ingreso = hora_ingreso;
		Estado = estado;
		this.vehiculo = vehiculo;
	}

	public int getId_vehingreso() {
		return Id_vehingreso;
	}

	public void setId_vehingreso(int id_vehingreso) {
		Id_vehingreso = id_vehingreso;
	}

	public String getFecha_ingreso() {
		return Fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		Fecha_ingreso = fecha_ingreso;
	}

	public String getHora_ingreso() {
		return Hora_ingreso;
	}

	public void setHora_ingreso(String hora_ingreso) {
		Hora_ingreso = hora_ingreso;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	

}
