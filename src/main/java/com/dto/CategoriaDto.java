package com.dto;

public class CategoriaDto {
    private long idCategoria;
    private String name;
    private String description;

    public CategoriaDto() {
    }

    public CategoriaDto(long idCategoria, String name, String description) {
        this.idCategoria = idCategoria;
        this.name = name;
        this.description = description;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
