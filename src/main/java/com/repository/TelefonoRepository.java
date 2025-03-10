package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dto.TelefonoUsuarioDto;
import com.model.Telefono;

public interface TelefonoRepository extends JpaRepository<Telefono, Long> {

    //ListarTelefonosYUsuarios
    @Query("SELECT new com.dto.TelefonoUsuarioDto(t.idTelefono, t.celular, t.tipo, t.isPrimary, " +
        "u.idUsuario, u.nombre, u.nombreUsuario, u.email) " +
        "FROM Telefono t JOIN t.usuario u")
    List<TelefonoUsuarioDto> findAllTelefonosYUsuarios();
    
    
    
}
