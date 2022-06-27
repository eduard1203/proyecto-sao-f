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
@Table(name = "alquiler")
public class Alquiler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id_alquiler;
	private String fecha_alquiler;
	private String hora_alquiler;
	private int valor;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_solicitud")
	private Solicitudes solicitudes;

	public Alquiler() {
		super();
	}

	public Alquiler(int id_alquiler, String fecha_alquiler, String hora_alquiler, int valor, String estado,
			Solicitudes solicitudes) {
		super();
		this.id_alquiler = id_alquiler;
		this.fecha_alquiler = fecha_alquiler;
		this.hora_alquiler = hora_alquiler;
		this.valor = valor;
		this.estado = estado;
		this.solicitudes = solicitudes;
	}

	public int getId_alquiler() {
		return id_alquiler;
	}

	public void setId_alquiler(int id_alquiler) {
		this.id_alquiler = id_alquiler;
	}

	public String getFecha_alquiler() {
		return fecha_alquiler;
	}

	public void setFecha_alquiler(String fecha_alquiler) {
		this.fecha_alquiler = fecha_alquiler;
	}

	public String getHora_alquiler() {
		return hora_alquiler;
	}

	public void setHora_alquiler(String hora_alquiler) {
		this.hora_alquiler = hora_alquiler;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Solicitudes getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(Solicitudes solicitudes) {
		this.solicitudes = solicitudes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
