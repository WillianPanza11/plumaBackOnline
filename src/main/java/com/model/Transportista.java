package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transportista")
public class Transportista {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transportista", nullable = false)
	private Long idTransportista;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 15)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String vehiculo;

    @Column(nullable = true, length = 10)
    private String placa;

    @Column(nullable = false)
    private boolean activo;

    @OneToMany(mappedBy = "transportista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrega> entregas;

    @OneToMany(mappedBy = "transportista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransportistaTelefono> telefonos;
}
