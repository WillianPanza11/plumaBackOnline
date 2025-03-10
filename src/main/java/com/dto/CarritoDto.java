package com.dto;

import java.time.LocalDateTime;

public class CarritoDto {
    private Long idCarrito;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String estado;
    private Long idUsuario;

    public CarritoDto() {
    }

    public CarritoDto(Long idCarrito, LocalDateTime createdAt, LocalDateTime updatedAt, String estado, Long idUsuario) {
        this.idCarrito = idCarrito;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

}
