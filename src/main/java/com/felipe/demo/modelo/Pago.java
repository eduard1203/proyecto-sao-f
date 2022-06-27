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
@Table(name = "pago")
public class Pago implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_pago;
	private String Fecha;
	private String Hora;
	private String Concepto;
	private String Medio_pago;
	private String Estado;
	
	@ManyToOne
	@JoinColumn(name = "doc_usuario")
	private Usuario usuario;

	public Pago() {
		super();
	}

	public Pago(int id_pago, String fecha, String hora, String concepto, String medio_pago, String estado, Usuario usuario) {
		super();
		Id_pago = id_pago;
		Fecha = fecha;
		Hora = hora;
		Concepto = concepto;
		Medio_pago = medio_pago;
		Estado = estado;
		this.usuario = usuario;
	}

	public int getId_pago() {
		return Id_pago;
	}

	public void setId_pago(int id_pago) {
		Id_pago = id_pago;
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

	public String getMedio_pago() {
		return Medio_pago;
	}

	public void setMedio_pago(String medio_pago) {
		Medio_pago = medio_pago;
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
