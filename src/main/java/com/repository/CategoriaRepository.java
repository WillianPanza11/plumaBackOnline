package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dto.CategoriaDto;
import com.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    //Ignorar mayúsculas y minúsculas y buscar por fragmentos de palabras
    Optional<Categoria> findByNameContainingIgnoreCase(String nombreCategoria);

    @Query("SELECT new com.dto.CategoriaDto(c.idCategoria, c.name, c.description) "+
    "FROM Categoria c") 
    List<CategoriaDto> findAllCategorias();

}
