package com.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CarritoDto;
import com.model.Carrito;
import com.repository.CarritoRepository;
import com.security.entity.Usuario;
import com.security.repository.UsuarioRepository;
import com.util.GenericResponse;

@Service
public class CarritoService {
    private static final Logger log = LoggerFactory.getLogger(CarritoService.class);

    @Autowired
    private CarritoRepository carritoRepository;
    private UsuarioRepository usuarioRepository;

    public GenericResponse<CarritoDto> obtenerOCrearCarrito(Long idUsuario) {
        GenericResponse<CarritoDto> response = new GenericResponse<>();
        
        return response;
    }
}
