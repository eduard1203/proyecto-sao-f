package com.felipe.demo.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.technicalkeeda"})
@Entity
@Table(name = "ingresos")
public class Ingresos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id_ingreso;
	private String Fecha;
	private String Hora;
	private String Concepto;
	private String MedioPago;
	private int Monto;
	private String Estado;
	
	@ManyToOne
	@JoinColumn(name = "Doc_Usuario")
	private Usuario usuario;

	public Ingresos() {
		super();
	}

	

	public Ingresos(int id_ingreso, String fecha, String hora, String concepto, String medioPago, int monto, String estado,
			Usuario usuario) {
		super();
		this.id_ingreso = id_ingreso;
		Fecha = fecha;
		Hora = hora;
		Concepto = concepto;
		MedioPago = medioPago;
		Monto = monto;
		Estado = estado;
		this.usuario = usuario;
	}

	public int getId_ingreso() {
		return id_ingreso;
	}



	public void setId_ingreso(int id_ingreso) {
		this.id_ingreso = id_ingreso;
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

	public String getConcepto() {
		return Concepto;
	}

	public void setConcepto(String concepto) {
		Concepto = concepto;
	}

	public String getMedioPago() {
		return MedioPago;
	}

	public void setMedioPago(String medioPago) {
		MedioPago = medioPago;
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
	
	

}
