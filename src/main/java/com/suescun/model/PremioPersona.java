package com.suescun.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "premios_personas")
public class PremioPersona {

	@Id
	@GeneratedValue
	private Integer id;
	
	@JoinColumn(name = "persona", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona persona;
	
	@JoinColumn(name = "premio", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Premio premio;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public Premio getPremio() {
		return premio;
	}
	
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
}
