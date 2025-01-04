package com.proyecto.spring;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.proyecto.spring.modelo.Rol;
import com.proyecto.spring.modelo.Usuario;
import com.proyecto.spring.repositorio.UsuarioRepositorio;

@SpringBootApplication
public class ProyectoLibreriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoLibreriaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initUsuarios(UsuarioRepositorio usuarioRepository) {
	    return (args) -> {
	        usuarioRepository.saveAll(Arrays.asList(
	            new Usuario("Juan Pérez", "juan.perez@example.com", "Calle Falsa 123", "contraseña_segura_1", 123456789, Rol.CLIENTE),
	            new Usuario("Ana García", "ana.garcia@example.com", "Avenida Siempre Viva 456", "contraseña_segura_2", 987654321, Rol.CLIENTE),
	            new Usuario("Carlos Torres", "carlos.torres@example.com", "Calle Larga 789", "contraseña_segura_3", 456789123, Rol.ADMIN),
	            new Usuario("María López", "maria.lopez@example.com", "Calle Luna 99", "contraseña_segura_4", 111222333, Rol.CLIENTE),
	            new Usuario("Pedro Fernández", "pedro.fernandez@example.com", "Calle Sol 101", "contraseña_segura_5", 222333444, Rol.CLIENTE),
	            new Usuario("Lucía Martínez", "lucia.martinez@example.com", "Avenida Estrellas 202", "contraseña_segura_6", 333444555, Rol.CLIENTE),
	            new Usuario("prueba", "prueba@gmail.com", "calle prueba123", "asd", 11223344, Rol.CLIENTE),
	            new Usuario("adminprueba", "prueba1@gmail.com", "calle prueba123", "asd", 11223344, Rol.ADMIN)
	        ));
	        usuarioRepository.findAll().forEach(System.out::println);
	    };
	}

}
