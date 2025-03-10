package com.security.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.Carrito;
import com.model.Direccion;
import com.model.Pedido;
import com.model.Resena;
import com.model.Telefono;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//clase que accede a la DB
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotNull
    @NotBlank(message = "El nombre no puede estar vacío")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El nombre solo puede contener letras")
    private String nombre;

    @NotNull
    @Column(unique = true)
    private String nombreUsuario;

    @NotNull(message = "El email no puede estar vacío")
    @Email(message = "Debe ingresar un email válido")
    private String email;

    @NotNull
    private String password;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    //@JsonIgnore
	//@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Telefono> telefonos = new ArrayList<>();

    @JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Direccion> direccion = new ArrayList<>();

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Carrito carrito;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Resena> resena = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pedido> pedido = new ArrayList<>();
    
    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public Usuario(Long idUsuario, @NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
            @NotNull String password, @NotNull Set<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
        //this.post = post;
    }

    public Usuario(Long idUsuario, @NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
            @NotNull String password, @NotNull Set<Rol> roles, List<Telefono> telefonos) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.telefonos = telefonos;
    }

    public Usuario(Long idUsuario, @NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
            @NotNull String password, @NotNull Set<Rol> roles, List<Telefono> telefonos, List<Direccion> direccion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.telefonos = telefonos;
        this.direccion = direccion;
    }

    public Usuario(Long idUsuario, @NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
            @NotNull String password, @NotNull Set<Rol> roles, List<Telefono> telefonos, List<Direccion> direccion,
            Carrito carrito) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.telefonos = telefonos;
        this.direccion = direccion;
        this.carrito = carrito;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(List<Direccion> direccion) {
        this.direccion = direccion;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    

}