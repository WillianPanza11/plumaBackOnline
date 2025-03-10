package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    
}
