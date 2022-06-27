package com.felipe.demo.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "solicitudes")
public class Solicitudes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Id_solicitud;
	private String Fecha;
	private String Hora;
	private String Tipo_solicitud;
	private String Medio_pago;
	private String Estado;
	
	@ManyToOne
	@JoinColumn(name = "doc_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "solicitudes")
	private List<Alquiler> alquilerLista;

	public Solicitudes() {
		super();
	}

	public Solicitudes(int id_solicitud, String fecha, String hora, String tipo_solicitud, String medio_pago, String estado,
			Usuario usuario, List<Alquiler> alquilerLista) {
		super();
		Id_solicitud = id_solicitud;
		Fecha = fecha;
		Hora = hora;
		Tipo_solicitud = tipo_solicitud;
		Medio_pago = medio_pago;
		Estado = estado;
		this.usuario = usuario;
		this.alquilerLista = alquilerLista;
	}

	public int getId_solicitud() {
		return Id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		Id_solicitud = id_solicitud;
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

	public String getTipo_solicitud() {
		return Tipo_solicitud;
	}

	public void setTipo_solicitud(String tipo_solicitud) {
		Tipo_solicitud = tipo_solicitud;
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

	public List<Alquiler> getAlquilerLista() {
		return alquilerLista;
	}

	public void setAlquilerLista(List<Alquiler> alquilerLista) {
		this.alquilerLista = alquilerLista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
