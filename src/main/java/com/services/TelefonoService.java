package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.TelefonoDto;
import com.dto.TelefonoUsuarioDto;
import com.model.Telefono;
import com.repository.TelefonoRepository;
import com.security.entity.Usuario;
import com.util.GenericResponse;
import com.util.ParametersApp;

@Service
public class TelefonoService {
	private static final Logger log = LoggerFactory.getLogger(TelefonoService.class);

	@Autowired
	private TelefonoRepository telefonoRepository;

	public GenericResponse<List<TelefonoUsuarioDto>> listAllTelefonosYUsuarios() {
		GenericResponse<List<TelefonoUsuarioDto>> response = new GenericResponse<>();
		try {
			List<TelefonoUsuarioDto> telefonos = telefonoRepository.findAllTelefonosYUsuarios();
			if (telefonos != null && !telefonos.isEmpty()) {
				response.setMessage("Lista de teléfonos y usuarios obtenida correctamente");
				response.setObject(telefonos);
				response.setStatus(ParametersApp.SUCCESSFUL.value());
			} else {
				response.setMessage("No se encontraron teléfonos y usuarios");
				response.setObject(null);
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			log.error("Error al obtener lista de teléfonos y usuarios: {} - Causa: {}", e.getMessage(), e.getCause(),
					e);
			response.setMessage("Error interno al obtener lista de teléfonos y usuarios");
			response.setStatus(ParametersApp.SERVER_ERROR.value());
		}
		return response;
	}

	// Transaion para evitar errores si no se guarda correctamente
	@Transactional
	public GenericResponse<String> saveTelefono(TelefonoDto telefonoDto) {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			// validar id de usuario que existe
			if (telefonoDto != null) {
				Usuario usuario = new Usuario();
				Telefono telefono = new Telefono();
				telefono.setCelular(telefonoDto.getCelular());
				telefono.setTipo(telefonoDto.getTipo());
				telefono.setIsPrimary(telefonoDto.getIsPrimary());
				// telefono.getUsuario().setIdUsuario(telefonoDto.getIdUsuario());
				usuario.setIdUsuario(telefonoDto.getIdUsuario());
				telefono.setUsuario(usuario);
				telefonoRepository.save(telefono);
				response.setMessage("Telefono guardado correctamente");
				response.setObject(ParametersApp.SUCCESSFUL.name());
				response.setStatus(ParametersApp.SUCCESSFUL.value());
			} else {
				response.setMessage("Telefono no puede ser nulo");
				response.setObject(ParametersApp.PROCESS_NOT_COMPLETED.name());
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			log.error("Error al guardar teléfono: {} - Causa: {}", e.getMessage(), e.getCause(), e);
			response.setMessage("Error interno al guardar el teléfono");
			response.setStatus(ParametersApp.SERVER_ERROR.value());
		}
		return response;
	}

	public GenericResponse<String> updateDatosTelefono(TelefonoDto telefonoDto) {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			Telefono telefono = telefonoRepository.findById(telefonoDto.getIdTelefono()).orElse(null);
			if (telefono != null) {
				telefono.setCelular(telefonoDto.getCelular());
				telefono.setTipo(telefonoDto.getTipo());
				telefono.setIsPrimary(telefonoDto.getIsPrimary());
				telefonoRepository.save(telefono);
				response.setMessage("Teléfono actualizado correctamente");
				response.setObject(ParametersApp.SUCCESSFUL.name());
				response.setStatus(ParametersApp.SUCCESSFUL.value());
			} else {
				response.setMessage("Teléfono no encontrado");
				response.setObject(ParametersApp.PROCESS_NOT_COMPLETED.name());
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			log.error("Error al actualizar teléfono: {} - Causa: {}", e.getMessage(), e.getCause(), e);
			response.setMessage("Error interno al actualizar el teléfono");
			response.setStatus(ParametersApp.SERVER_ERROR.value());
		}
		return response;
	}

	public GenericResponse<String> deleteTelefono(TelefonoDto telefonoDto) {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			Telefono telefono = telefonoRepository.findById(telefonoDto.getIdTelefono()).orElse(null);
			if (telefono != null) {
				telefonoRepository.delete(telefono);
				response.setMessage("Teléfono eliminado correctamente");
				response.setObject(ParametersApp.SUCCESSFUL.name());
				response.setStatus(ParametersApp.SUCCESSFUL.value());
			} else {
				response.setMessage("Teléfono no encontrado");
				response.setObject(ParametersApp.PROCESS_NOT_COMPLETED.name());
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			log.error("Error al eliminar teléfono: {} - Causa: {}", e.getMessage(), e.getCause(), e);
			response.setMessage("Error interno al eliminar el teléfono");
			response.setStatus(ParametersApp.SERVER_ERROR.value());
		}
		return response;
	}

	// Buscar telefono por id
	public GenericResponse<TelefonoDto> findTelefonoById(Long idTelefono) {
		GenericResponse<TelefonoDto> response = new GenericResponse<>();
		try {
			Telefono telefono = telefonoRepository.findById(idTelefono).orElse(null);
			if (telefono != null) {
				TelefonoDto telefonoDtoResponse = new TelefonoDto();
				telefonoDtoResponse.setIdTelefono(telefono.getIdTelefono());
				telefonoDtoResponse.setCelular(telefono.getCelular());
				telefonoDtoResponse.setTipo(telefono.getTipo());
				telefonoDtoResponse.setIsPrimary(telefono.getIsPrimary());
				telefonoDtoResponse.setIdUsuario(telefono.getUsuario().getIdUsuario());
				response.setMessage("Teléfono encontrado correctamente");
				response.setObject(telefonoDtoResponse);
				response.setStatus(ParametersApp.SUCCESSFUL.value());
			} else {
				response.setMessage("Teléfono no encontrado");
				response.setObject(null);
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			log.error("Error al buscar teléfono: {} - Causa: {}", e.getMessage(), e.getCause(), e);
			response.setMessage("Error interno al buscar el teléfono");
			response.setStatus(ParametersApp.SERVER_ERROR.value());
		}
		return response;
	}
}
