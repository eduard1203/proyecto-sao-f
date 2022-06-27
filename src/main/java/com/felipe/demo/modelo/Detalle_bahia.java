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
@Table(name = "detalle_bahia")
public class Detalle_bahia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_Detalle_Bahia;
	private int Documento;
	private String Placa;
	private String Fecha_ingreso;
	private String Hora_ingreso;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_bahia")
	private Bahia bahia;

	public Detalle_bahia() {
		super();
	}

	public Detalle_bahia(int id_Detalle_Bahia, int documento, String placa, String fecha_ingreso, String hora_ingreso,
			String estado, Bahia bahia) {
		super();
		Id_Detalle_Bahia = id_Detalle_Bahia;
		Documento = documento;
		Placa = placa;
		Fecha_ingreso = fecha_ingreso;
		Hora_ingreso = hora_ingreso;
		this.estado = estado;
		this.bahia = bahia;
	}

	public int getId_Detalle_Bahia() {
		return Id_Detalle_Bahia;
	}

	public void setId_Detalle_Bahia(int id_Detalle_Bahia) {
		Id_Detalle_Bahia = id_Detalle_Bahia;
	}

	public int getDocumento() {
		return Documento;
	}

	public void setDocumento(int documento) {
		Documento = documento;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
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
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Bahia getBahia() {
		return bahia;
	}

	public void setBahia(Bahia bahia) {
		this.bahia = bahia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
