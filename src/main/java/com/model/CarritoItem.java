package com.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CarritoItem {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrito_item", nullable = false)
	private Long idCarritoItem;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal pricioUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @CreationTimestamp
    @Column(name = "fecha_agregado", updatable = false, nullable = false)
    private LocalDateTime fechaAgregado;

    @JoinColumn(name = "id_carrito")
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonIgnore  // 👈 Oculta el usuario al serializar
	private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public CarritoItem() {
    }

    public CarritoItem(Long idCarritoItem, int cantidad, BigDecimal pricioUnitario, BigDecimal total,
            LocalDateTime fechaAgregado, Carrito carrito, Producto producto) {
        this.idCarritoItem = idCarritoItem;
        this.cantidad = cantidad;
        this.pricioUnitario = pricioUnitario;
        this.total = total;
        this.fechaAgregado = fechaAgregado;
        this.carrito = carrito;
        this.producto = producto;
    }

    

    


}
