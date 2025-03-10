package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CategoriaDto;
import com.model.Categoria;
import com.services.CategoriaService;
import com.util.GenericResponse;

@CrossOrigin
@RestController
@RequestMapping(path = "categoria")
public class CategoriaController {

    @Autowired
	private CategoriaService servicioCategoria;

    @GetMapping(path = "listarAllCategorias")
    public ResponseEntity<GenericResponse<List<CategoriaDto>>> listarAllCategorias(){
        return new ResponseEntity<GenericResponse<List<CategoriaDto>>>(servicioCategoria.listAllCategorias(), HttpStatus.OK);
    }

    //Guardar categoria
    @PostMapping(path = "saveCategoria")
    public ResponseEntity<GenericResponse<String>> saveCategoria(@RequestBody CategoriaDto categoriaDto) {
        return new ResponseEntity<GenericResponse<String>>(servicioCategoria.saveCategoria(categoriaDto), HttpStatus.OK);
    }

    //Actualizar categoria
    @PutMapping(path = "updateCategoria")
    public ResponseEntity<GenericResponse<String>> updateCategoria(@RequestBody CategoriaDto categoriaDto) {
        return new ResponseEntity<GenericResponse<String>>(servicioCategoria.updateCategoria(categoriaDto), HttpStatus.OK);
    }

    //Buscar categoria por nombre
    @GetMapping(path = "findCategoriaByNombre")
    public ResponseEntity<GenericResponse<CategoriaDto>> findCategoriaByNombre(String nombreCategoria) {
        return new ResponseEntity<GenericResponse<CategoriaDto>>(servicioCategoria.findCategoriaByName(nombreCategoria), HttpStatus.OK);
    }

    //Buscar categoria por id
    @GetMapping(path = "findCategoriaById")
    public ResponseEntity<GenericResponse<CategoriaDto>> findCategoriaById(Long idCategoria) {
        return new ResponseEntity<GenericResponse<CategoriaDto>>(servicioCategoria.findCategoriaById(idCategoria), HttpStatus.OK);
    }

}
