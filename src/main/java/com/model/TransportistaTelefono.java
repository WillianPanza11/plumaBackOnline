package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.security.enums.TipoTelefono;

@Entity
@Table(name = "transportistaTelefono")
public class TransportistaTelefono {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transportista_telfono", nullable = false)
	private Long idTransportistaTelefono;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoTelefono tipo;
    
    @ManyToOne
    @JoinColumn(name = "id_transportista", nullable = false)
    private Transportista transportista;

    public TransportistaTelefono() {
    }

    public TransportistaTelefono(Long idTransportistaTelefono, String telefono, TipoTelefono tipo,
            Transportista transportista) {
        this.idTransportistaTelefono = idTransportistaTelefono;
        this.telefono = telefono;
        this.tipo = tipo;
        this.transportista = transportista;
    }

    public Long getIdTransportistaTelefono() {
        return idTransportistaTelefono;
    }

    public void setIdTransportistaTelefono(Long idTransportistaTelefono) {
        this.idTransportistaTelefono = idTransportistaTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoTelefono getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefono tipo) {
        this.tipo = tipo;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    

}
