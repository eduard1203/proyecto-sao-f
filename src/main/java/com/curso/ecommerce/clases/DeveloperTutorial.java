package com.curso.ecommerce.clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "developer_tutorial")

public class DeveloperTutorial {

	  @Id
	  @Column(name = "id")
	  private long id;

	  @Column(name = "nombre")
	  private String nombre;

	  @Column(name = "direccion")
	  private String direccion;

	  @Column(name = "ciudad")
	  private String ciudad;
          
          @Column(name = "estado")
	  private String estado;
          
          @Column(name = "rol")
	  private String rol;
          
          @Column(name = "celular")
	  private long celular;
          
          @Column(name = "clave")
	  private String clave;
          
	  public DeveloperTutorial() {

	  }

    public DeveloperTutorial(long id, String nombre, String direccion, String ciudad, String estado, String rol, long celular, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.rol = rol;
        this.celular = celular;
        this.clave = clave;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

          
        

	  
	}