package com.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.security.entity.Usuario;

@Entity
@Table(name = "resena")
public class Resena {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resena", nullable = false)
	private Long idResena;

    @Column(nullable = false)
    private int rating; // Valor de 1 a 5

    @Column(length = 500)
    private String comentario;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Resena() {
    }

    public Resena(Long idResena, Producto producto, Usuario usuario) {
        this.idResena = idResena;
        this.producto = producto;
        this.usuario = usuario;
    }

    

}
