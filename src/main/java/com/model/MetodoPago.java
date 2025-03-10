package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_metodo_pago", nullable = false)
	private Long idMetodoPago;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(length = 10)
    private String activo;

    @OneToMany(mappedBy = "metodoPago")
    private List<Pedido> pedidos;

    public MetodoPago() {
    }

    public MetodoPago(Long idMetodoPago, String nombre, String activo, List<Pedido> pedidos) {
        this.idMetodoPago = idMetodoPago;
        this.nombre = nombre;
        this.activo = activo;
        this.pedidos = pedidos;
    }

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
    

}
