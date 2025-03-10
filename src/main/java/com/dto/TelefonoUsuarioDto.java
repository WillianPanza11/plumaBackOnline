package com.dto;

public class TelefonoUsuarioDto {
    private Long idTelefono;
    private String celular;
    private String tipo;
    private String isPrimary;
    private Long idUsuario;
    private String nombre;
    private String nombreUsuario;
    private String email;
    
    public TelefonoUsuarioDto() {
    }

    public TelefonoUsuarioDto(Long idTelefono, String celular, String tipo, String isPrimary, Long idUsuario,
            String nombre, String nombreUsuario, String email) {
        this.idTelefono = idTelefono;
        this.celular = celular;
        this.tipo = tipo;
        this.isPrimary = isPrimary;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }
}
