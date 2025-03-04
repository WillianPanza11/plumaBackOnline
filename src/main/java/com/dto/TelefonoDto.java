package com.dto;

public class TelefonoDto {
    private Long idTelefono;
    private String celular;
    private String tipo;
    private boolean isPrimary;
	private Long idUsuario;

    public TelefonoDto() {
    }
    
    public TelefonoDto(Long idTelefono, String celular, String tipo, boolean isPrimary, Long idUsuario) {
        this.idTelefono = idTelefono;
        this.celular = celular;
        this.tipo = tipo;
        this.isPrimary = isPrimary;
        this.idUsuario = idUsuario;
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
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
   
}
