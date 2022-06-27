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

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.technicalkeeda"})
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String marca;
	private String color;
	private int modelo;
	private String placa;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "doc_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Parqueadero> parquederoLista;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Ingreso_vehiculos> ingresoVehiculosLista;

	public Vehiculo() {
		super();
	}

	public Vehiculo(int id, String marca, String color, int modelo, String placa, String estado, Usuario usuario,
			List<Parqueadero> parquederoLista, List<Ingreso_vehiculos> ingresoVehiculosLista) {
		super();
		this.id = id;
		this.marca = marca;
		this.color = color;
		this.modelo = modelo;
		this.placa = placa;
		this.estado = estado;
		this.usuario = usuario;
		this.parquederoLista = parquederoLista;
		this.ingresoVehiculosLista = ingresoVehiculosLista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Parqueadero> getParquederoLista() {
		return parquederoLista;
	}

	public void setParquederoLista(List<Parqueadero> parquederoLista) {
		this.parquederoLista = parquederoLista;
	}

	public List<Ingreso_vehiculos> getIngresoVehiculosLista() {
		return ingresoVehiculosLista;
	}

	public void setIngresoVehiculosLista(List<Ingreso_vehiculos> ingresoVehiculosLista) {
		this.ingresoVehiculosLista = ingresoVehiculosLista;
	}	
}
