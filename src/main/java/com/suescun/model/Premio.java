package com.suescun.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "premios")
public class Premio {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="codigo", length = 3)
	private String codigo;
	
	@Column(name="descripcion", length = 100)
	private String descripcion;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@OneToMany(mappedBy = "premio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PremioPersona> personas;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
