package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
