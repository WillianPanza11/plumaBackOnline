package com.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.security.dto.NuevoUsuario;
import com.security.entity.Rol;
import com.security.entity.Usuario;
import com.security.enums.RolNombre;
import com.security.service.RolService;
import com.security.service.UsuarioService;



/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;
    
    @Autowired
    UsuarioService usuarioService; 
    
    @Autowired
    PasswordEncoder passwordEncoder;
    

	@Override
	public void run(String... args) throws Exception {
		/*
		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser = new Rol(RolNombre.ROLE_USER);
		rolService.save(rolAdmin);
		rolService.save(rolUser);

		NuevoUsuario nuevoUser = new NuevoUsuario();
		nuevoUser.setNombre("admin");
		nuevoUser.setNombreUsuario("admin");
		nuevoUser.setEmail("wrpanza@gerardoortiz.com");

		Usuario user = new Usuario(nuevoUser.getNombre(), nuevoUser.getNombreUsuario(), nuevoUser.getEmail(),
				passwordEncoder.encode(nuevoUser.getNombre()));

		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		user.setRoles(roles);
		usuarioService.save(user);
		 */
	}
}
