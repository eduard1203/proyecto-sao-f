package com.felipe.demo.modelo;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "permiso")
public class Permiso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int Id_permiso;
	private String Descripcion;
	
	@OneToMany(mappedBy = "permiso")
	private List<Rol> rolLista;

	public Permiso() {
		super();
	}

	public Permiso(int id_permiso, String descripcion, List<Rol> rolLista) {
		super();
		Id_permiso = id_permiso;
		Descripcion = descripcion;
		this.rolLista = rolLista;
	}

	public int getId_permiso() {
		return Id_permiso;
	}

	public void setId_permiso(int id_permiso) {
		Id_permiso = id_permiso;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public List<Rol> getRolLista() {
		return rolLista;
	}

	public void setRolLista(List<Rol> rolLista) {
		this.rolLista = rolLista;
	}
	
	

}
