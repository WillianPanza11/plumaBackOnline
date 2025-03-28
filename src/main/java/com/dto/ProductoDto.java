package com.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.model.Producto;

public class ProductoDto {
    private long idProducto;
    private String nombreProducto;
    private String descriptionProducto;
    private BigDecimal precioProducto;
    private int stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String estado;
    private String imageUrl;
    private Long idCategoria;

    public ProductoDto() {
    }

    public ProductoDto(Producto producto) {
        this.idProducto = producto.getIdProducto();
        this.nombreProducto = producto.getNombreProducto(); 
        this.descriptionProducto = producto.getDescriptionProducto();
        this.precioProducto = producto.getPrecioProducto();
        this.stock = producto.getStock();
        this.createdAt = producto.getCreatedAt();
        this.updatedAt = producto.getUpdatedAt();
        this.estado = producto.getEstado();
        this.imageUrl = producto.getImageUrl();
        this.idCategoria = producto.getCategoria().getIdCategoria();

    }

    public ProductoDto(long idProducto, String nombreProducto, String descriptionProducto, BigDecimal precioProducto,
            int stock, LocalDateTime createdAt, LocalDateTime updatedAt, String estado, String imageUrl,
            Long idCategoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descriptionProducto = descriptionProducto;
        this.precioProducto = precioProducto;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.estado = estado;
        this.imageUrl = imageUrl;
        this.idCategoria = idCategoria;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescriptionProducto() {
        return descriptionProducto;
    }

    public void setDescriptionProducto(String descriptionProducto) {
        this.descriptionProducto = descriptionProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    

    

}
