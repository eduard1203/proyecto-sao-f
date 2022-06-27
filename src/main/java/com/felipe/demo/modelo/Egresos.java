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
@Table(name = "egresos")
public class Egresos implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_Egreso;
	private String Descripcion;
	private String Fecha;
	private String Hora;
	private int Monto;
	private String Estado;
	
	@ManyToOne
	@JoinColumn(name = "doc_usuario")
	private Usuario usuario;

	public Egresos() {
		super();
	}

	public Egresos(int id_Egreso, String descripcion, String fecha, String hora, int monto, String estado,
			Usuario usuario) {
		super();
		Id_Egreso = id_Egreso;
		Descripcion = descripcion;
		Fecha = fecha;
		Hora = hora;
		Monto = monto;
		Estado = estado;
		this.usuario = usuario;
	}

	public int getId_Egreso() {
		return Id_Egreso;
	}

	public void setId_Egreso(int id_Egreso) {
		Id_Egreso = id_Egreso;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
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

	public int getMonto() {
		return Monto;
	}

	public void setMonto(int monto) {
		Monto = monto;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
}
