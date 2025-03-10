package com.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CategoriaDto;
import com.model.Categoria;
import com.repository.CategoriaRepository;
import com.util.GenericResponse;
import com.util.ParametersApp;

@Service
public class CategoriaService {
    private static final Logger log = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar categorías
    public GenericResponse<List<CategoriaDto>> listAllCategorias() {
        GenericResponse<List<CategoriaDto>> response = new GenericResponse<>();
        try {
            List<CategoriaDto> categorias = categoriaRepository.findAllCategorias();
            if (categorias != null && !categorias.isEmpty()) {
                response.setMessage("Lista de categorías obtenida correctamente");
                response.setObject(categorias);
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("No se encontraron categorías");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            log.error("Error al obtener lista de categorías: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al obtener lista de categorías");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }

    // Guardar categoría
    public GenericResponse<String> saveCategoria(CategoriaDto categoriaDto) {
        GenericResponse<String> response = new GenericResponse<>();
        try {
            if (categoriaDto != null) {
                Categoria categoria = new Categoria();
                categoria.setName(categoriaDto.getName());
                categoria.setDescription(categoriaDto.getDescription());
                categoriaRepository.save(categoria);
                response.setMessage("Categoría guardada correctamente");
                response.setObject(ParametersApp.SUCCESSFUL.name());
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("No se pudo guardar la categoría");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            log.error("Error al guardar categoría: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al guardar categoría");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }

    // Actualizar categoría
    public GenericResponse<String> updateCategoria(CategoriaDto categoriaDto) {
        GenericResponse<String> response = new GenericResponse<>();
        try {
            if(categoriaDto == null) {
                response.setMessage("No se pudo actualizar la categoría");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
                return response;
            }

            Categoria categoria = categoriaRepository.findById(categoriaDto.getIdCategoria()).orElse(null);
            if(categoria != null) {
                categoria.setName(categoriaDto.getName());
                categoria.setDescription(categoriaDto.getDescription());
                categoriaRepository.save(categoria);
                response.setMessage("Categoría actualizada correctamente");
                response.setObject(ParametersApp.SUCCESSFUL.name());
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("No se encontró la categoría a actualizar");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            log.error("Error al actualizar categoría: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al actualizar categoría");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
            return response;
    }

    // Buscar categoría por id
    public GenericResponse<CategoriaDto> findCategoriaById(long idCategoria) {
        GenericResponse<CategoriaDto> response = new GenericResponse<>();
        try {
            Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
            if(categoria != null) {
                CategoriaDto categoriaDto = new CategoriaDto();
                categoriaDto.setIdCategoria(categoria.getIdCategoria());
                categoriaDto.setName(categoria.getName());
                categoriaDto.setDescription(categoria.getDescription());
                response.setMessage("Categoría encontrada");
                response.setObject(categoriaDto);
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("Categoría no encontrada");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            log.error("Error al buscar categoría por id: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al buscar categoría por id");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }

    // Buscar categoria por nombre
    public GenericResponse<CategoriaDto> findCategoriaByName(String nombreCategoria) {
    
        GenericResponse<CategoriaDto> response = new GenericResponse<>();
        if (nombreCategoria == null) {
            response.setMessage("Nombre de categoría no puede ser nulo");
            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            return response;
        }

        try {
            Categoria categoria = categoriaRepository.findByNameContainingIgnoreCase(nombreCategoria).orElse(null);
            if (categoria != null) {
                CategoriaDto categoriaDto = new CategoriaDto();
                categoriaDto.setIdCategoria(categoria.getIdCategoria());
                categoriaDto.setName(categoria.getName());
                categoriaDto.setDescription(categoria.getDescription());
                response.setMessage("Categoría encontrada");
                response.setObject(categoriaDto);
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage("Categoría no encontrada");
                response.setObject(null);
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            log.error("Error al buscar categoría por nombre: {} - Causa: {}", e.getMessage(), e.getCause(), e);
            response.setMessage("Error interno al buscar categoría por nombre");
            response.setStatus(ParametersApp.SERVER_ERROR.value());
        }
        return response;
    }
}
