package com.repository;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dto.ProductoDto;
import com.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //Listar Todos Los Productos paginados
    Page<Producto> findAll(Pageable pageable);

    //Listar Todos Los Productos
    @Query("SELECT new com.dto.ProductoDto(p.idProducto, p.nombreProducto, p.descriptionProducto, p.precioProducto, p.stock, p.createdAt, p.updatedAt, p.estado, p.imageUrl, p.categoria.id) " +
    "FROM Producto p")
    List<ProductoDto> findAllProductos();

    //Buscar Producto por nombre
    List<ProductoDto> findByNombreProductoContainingIgnoreCase(String nombreProducto);



}
