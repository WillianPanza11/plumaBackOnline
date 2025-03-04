package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.entity.Usuario;
import com.sun.istack.NotNull;

@Entity
@Table(name = "telefono")
public class Telefono {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefono", nullable = false)
	private Long idTelefono;
	
	@NotNull
    private String celular;
	
	@NotNull
    private String tipo;
	
	@NotNull
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isPrimary;
	
	//@JoinColumn(name = "usuario_id")
	//@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
	@JsonIgnore  // 👈 Oculta el usuario al serializar
	private Usuario usuario;
	
	public Telefono() {
	}

	public Telefono(Long idTelefono, String celular, String tipo, boolean isPrimary, Usuario usuario) {
		this.idTelefono = idTelefono;
		this.celular = celular;
		this.tipo = tipo;
		this.isPrimary = isPrimary;
		this.usuario = usuario;
	}

	public Long getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
