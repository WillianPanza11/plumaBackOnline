package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ProductoDto;
import com.services.ProductoService;
import com.util.GenericResponse;

@CrossOrigin
@RestController
@RequestMapping(path = "producto")
public class ProductoController {

    @Autowired
	private ProductoService productoService; 

    @GetMapping(path = "listarAllProductos")
    public ResponseEntity<GenericResponse<Page<ProductoDto>>> listarAllProductos(Pageable pageable){
        return ResponseEntity.ok(productoService.listAllProductosPaginados(pageable));
    }

    //Guardar producto
    @PostMapping(path = "saveProducto")
    public ResponseEntity<GenericResponse<String>> saveProducto(@RequestBody ProductoDto productoDto) {
        return ResponseEntity.ok(productoService.saveProducto(productoDto));
    }

    //Actualizar producto
    @PutMapping(path = "updateProducto")
    public ResponseEntity<GenericResponse<String>> updateProducto(@RequestBody ProductoDto productoDto) {
        return new ResponseEntity<GenericResponse<String>>(productoService.updateProducto(productoDto), HttpStatus.OK);
    }

    //Buscar producto por nombre
    @GetMapping(path = "findProductoByNombre")
    public ResponseEntity<GenericResponse<List<ProductoDto>>> findProductoByNombre(String nombreProducto) {
        return new ResponseEntity<GenericResponse<List<ProductoDto>>>(productoService.findProductoByNombre(nombreProducto), HttpStatus.OK);
    }

}
