package com.felipe.demo.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Rol")
public class Rol implements Serializable{
		
	private static final long serialVersionUID = 1L;
	@Id
	private int id_Rol;
	private String Nom_Rol;
	
	@ManyToOne
	@JoinColumn(name = "id_permiso")
	private Permiso permiso;

	public Rol() {
		super();
	}

	public Rol(int id_Rol, String nom_Rol, Permiso permiso) {
		super();
		this.id_Rol = id_Rol;
		Nom_Rol = nom_Rol;
		this.permiso = permiso;
	}

	public int getId_Rol() {
		return id_Rol;
	}

	public void setId_Rol(int id_Rol) {
		this.id_Rol = id_Rol;
	}

	public String getNom_Rol() {
		return Nom_Rol;
	}

	public void setNom_Rol(String nom_Rol) {
		Nom_Rol = nom_Rol;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Rol(String nom_Rol) {
		super();
		Nom_Rol = nom_Rol;
	}

	
		
			
}

