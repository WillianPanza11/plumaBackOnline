package com.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.ProductoDto;
import com.model.Categoria;
import com.model.Producto;
import com.repository.ProductoRepository;
import com.util.GenericResponse;
import com.util.ParametersApp;

@Service
public class ProductoService {
    private static final Logger log = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private ProductoRepository productoRepository;

    // listar todos los productos
    public GenericResponse<List<ProductoDto>> listAllProductos() {
        GenericResponse<List<ProductoDto>> response = new GenericResponse<>();
        try {
            List<ProductoDto> productos = productoRepository.findAllProductos();
            if (productos != null && !productos.isEmpty()) {
                response.setMessage("Lista de productos obtenida correctamente");
                response.setObject(productos);
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("No se encontraron productos");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            log.error("Error al obtener lista de productos: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al obtener lista de productos");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }

    // Listar producto paginado
    public GenericResponse<Page<ProductoDto>> listAllProductosPaginados(Pageable pageable) {
        GenericResponse<Page<ProductoDto>> response = new GenericResponse<>();
        try {
            Page<Producto> productos = productoRepository.findAll(pageable);
            if (productos != null && !productos.isEmpty()) {
                response.setMessage("Lista de productos paginados obtenida correctamente");
                // ✅ Convert entity to DTO
                response.setObject(productos.map(ProductoDto::new));
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("No se encontraron productos paginados");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }

        } catch (Exception e) {
            log.error("Error al obtener lista de productos paginados: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al obtener lista de productos paginados");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }

    // Guardar producto
    public GenericResponse<String> saveProducto(ProductoDto productoDto) {
        GenericResponse<String> response = new GenericResponse<>();
        try {
            if (productoDto != null) {
                Producto producto = new Producto();
                Categoria categoria = new Categoria();
                producto.setNombreProducto(productoDto.getNombreProducto() != null ? productoDto.getNombreProducto() : "Sin nombre de producto");
                producto.setDescriptionProducto(productoDto.getDescriptionProducto() != null ? productoDto.getDescriptionProducto() : "Sin descripción de producto");
                producto.setPrecioProducto(productoDto.getPrecioProducto() != null ? productoDto.getPrecioProducto() : null);
                producto.setStock(productoDto.getStock() != 0 ? productoDto.getStock() : 0);
                producto.setCreatedAt(productoDto.getCreatedAt() != null ? productoDto.getCreatedAt() : null);
                producto.setUpdatedAt(productoDto.getUpdatedAt() != null ? productoDto.getUpdatedAt() : null);
                producto.setEstado(productoDto.getEstado() != null ? productoDto.getEstado() : "Activo");
                producto.setImageUrl(productoDto.getImageUrl() != null ? productoDto.getImageUrl() : null);
                categoria.setIdCategoria(productoDto.getIdCategoria());
                //producto.getCategoria().setIdCategoria(productoDto.getIdProducto());
                productoRepository.save(producto);
                response.setMessage("Producto guardado correctamente");
                response.setObject(ParametersApp.SUCCESSFUL.name());
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("Producto no puede ser nulo");
                response.setObject(ParametersApp.PROCESS_NOT_COMPLETED.name());
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            log.error("Error al guardar producto: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al guardar producto");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }

    // Actualizar producto
    public GenericResponse<String> updateProducto(ProductoDto productoDto) {
        GenericResponse<String> response = new GenericResponse<>();
        try {
            Producto producto = productoRepository.findById(productoDto.getIdProducto()).orElse(null);
            if (producto != null) {
                producto.setNombreProducto(productoDto.getNombreProducto() != null ? productoDto.getNombreProducto() : "Sin nombre de producto");
                producto.setDescriptionProducto(productoDto.getDescriptionProducto() != null ? productoDto.getDescriptionProducto() : "Sin descripción de producto");
                producto.setPrecioProducto(productoDto.getPrecioProducto() != null ? productoDto.getPrecioProducto() : null);
                producto.setStock(productoDto.getStock() != 0 ? productoDto.getStock() : 0);
                producto.setCreatedAt(productoDto.getCreatedAt() != null ? productoDto.getCreatedAt() : null);
                producto.setUpdatedAt(productoDto.getUpdatedAt() != null ? productoDto.getUpdatedAt() : null);
                producto.setEstado(productoDto.getEstado() != null ? productoDto.getEstado() : "Activo");
                producto.setImageUrl(productoDto.getImageUrl() != null ? productoDto.getImageUrl() : null);
                //producto.setIdProducto(productoDto.getIdProducto());

                productoRepository.save(producto);
                response.setMessage("Producto actualizado correctamente");
                response.setObject(ParametersApp.SUCCESSFUL.name());
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("Producto no encontrado");
                response.setObject(ParametersApp.PROCESS_NOT_COMPLETED.name());
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            log.error("Error al actualizar producto: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al actualizar producto");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }

    // Buscar producto por nombre
    public GenericResponse<List<ProductoDto>> findProductoByNombre(String nombreProducto) {
        GenericResponse<List<ProductoDto>> response = new GenericResponse<>();
        try {
            if(nombreProducto==null){
                response.setMessage("Nombre de producto no puede ser nulo");
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
                return response;
            }

            List<ProductoDto> productos = productoRepository.findByNombreProductoContainingIgnoreCase(nombreProducto);
            if (productos != null && !productos.isEmpty()) {
                response.setMessage("Producto encontrado");
                response.setObject(productos);
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("Producto no encontrado");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }

            
        } catch (Exception e) {
            log.error("Error al buscar producto por nombre: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al buscar producto por nombre");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }

}
