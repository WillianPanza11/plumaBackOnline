package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.TelefonoDto;
import com.model.Telefono;
import com.services.TelefonoService;
import com.util.GenericResponse;

@CrossOrigin
@RestController
@RequestMapping(path = "consultaExterna")
public class TelefonoController {
    @Autowired
	private TelefonoService servicio;

    @PostMapping(path = "saveTelefono")
    public ResponseEntity<GenericResponse<String>> saveTelefono(@RequestBody TelefonoDto telefonoDto) {
        return new ResponseEntity<GenericResponse<String>>(servicio.saveTelefono(telefonoDto), HttpStatus.OK);
        //return ResponseEntity.ok(servicio.saveTelefono(telefono));
    }
}
