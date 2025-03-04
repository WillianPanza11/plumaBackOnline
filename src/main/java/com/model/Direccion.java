package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.entity.Usuario;

@Entity
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direccion", nullable = false)
	private Long idDireccion;
	
	@Column(name = "direccion",length = 50)
    private String direccion; 
	
	@Column(name = "ciudad",length = 50)
    private String ciudad; 
	
	@Column(name = "provincia",length = 50)
    private String provincia; 
	
	@Column(name = "Pais",length = 50)
    private String pais; 
	
	@Column(name = "is_primary")
    private boolean isPrimary; 
	
	@JoinColumn(name = "usuario_id")
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonIgnore  // 👈 Oculta el usuario al serializar
	private Usuario usuario;

	public Direccion() {
	}

	public Direccion(Long idDireccion, String direccion, String ciudad, String provincia, String pais,
			boolean isPrimary, Usuario usuario) {
		this.idDireccion = idDireccion;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
		this.isPrimary = isPrimary;
		this.usuario = usuario;
	}

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
