package com.suescun.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="nombres", length = 100)
	private String nombres;
	
	@Column(name="apellidos", length = 100)
	private String apellidos;
	
	@Column(name="tipo_doc", length = 3)
	private String tipo_doc;
	
	@Column(name="documento", length = 12)
	private String documento;
	
	@Column(name="fecha_nacimiento", columnDefinition="timestamp")
	private Date fecha_nacimiento;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PremioPersona> premios;
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDocumento() {
		return documento;
	}
	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public String getTipo_doc() {
		return tipo_doc;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
