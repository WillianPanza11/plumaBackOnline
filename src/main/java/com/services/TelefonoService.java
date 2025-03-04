package com.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.TelefonoDto;
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
	
	//Transaion para evitar errores si no se guarda correctamente
	@Transactional
	public GenericResponse<String> saveTelefono(TelefonoDto telefonoDto) {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			//validar id de usuario que existe

			if(telefonoDto != null){
				Usuario usuario = new Usuario();
				Telefono telefono = new Telefono();
				telefono.setCelular(telefonoDto.getCelular());
				telefono.setTipo(telefonoDto.getTipo());
				telefono.setPrimary(telefonoDto.isPrimary());
				//telefono.getUsuario().setIdUsuario(telefonoDto.getIdUsuario());
				usuario.setIdUsuario(telefonoDto.getIdUsuario());
				telefono.setUsuario(usuario);
				telefonoRepository.save(telefono);
				response.setMessage("Telefono guardado correctamente");
				response.setObject(ParametersApp.SUCCESSFUL.name());
				response.setStatus(ParametersApp.SUCCESSFUL.value());
			}else{
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
}
