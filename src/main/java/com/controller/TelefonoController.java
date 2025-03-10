package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.TelefonoDto;
import com.dto.TelefonoUsuarioDto;
import com.services.TelefonoService;
import com.util.GenericResponse;

@CrossOrigin
@RestController
@RequestMapping(path = "telefono")
public class TelefonoController {
    @Autowired
	private TelefonoService servicioTelefono;

    @GetMapping(path = "listarTelefonosYUsuarios")
    public ResponseEntity<GenericResponse<List<TelefonoUsuarioDto>>> listarTelefonosYUsuarios(){
        return new ResponseEntity<GenericResponse<List<TelefonoUsuarioDto>>>(servicioTelefono.listAllTelefonosYUsuarios(), HttpStatus.OK);
    }

    @PostMapping(path = "saveTelefono")
    public ResponseEntity<GenericResponse<String>> saveTelefono(@RequestBody TelefonoDto telefonoDto) {
        return new ResponseEntity<GenericResponse<String>>(servicioTelefono.saveTelefono(telefonoDto), HttpStatus.OK);
        //return ResponseEntity.ok(servicio.saveTelefono(telefono));
    }

    @PutMapping(path = "updateTelefono")
    public ResponseEntity<GenericResponse<String>> updateTelefono(@RequestBody TelefonoDto telefonoDto) {
        return new ResponseEntity<GenericResponse<String>>(servicioTelefono.updateDatosTelefono(telefonoDto), HttpStatus.OK);
    }

    //Eliminar telefono
    @DeleteMapping(path = "deleteTelefono")
    public ResponseEntity<GenericResponse<String>> deleteTelefono(@RequestBody TelefonoDto telefonoDto) {
        return new ResponseEntity<GenericResponse<String>>(servicioTelefono.deleteTelefono(telefonoDto), HttpStatus.OK);
    }

    //Buscar telefono por id
    @GetMapping(path = "findTelefonoById")
    public ResponseEntity<GenericResponse<TelefonoDto>> findTelefonoById(@RequestParam Long idTelefono) {
        return new ResponseEntity<GenericResponse<TelefonoDto>>(servicioTelefono.findTelefonoById(idTelefono), HttpStatus.OK);
    }
}
