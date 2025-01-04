package com.proyecto.spring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombre(String nombre);
    
    @Query(value="select e from usuario u where lower(nombre) like concat('%',?1,'%')", nativeQuery=true)
    List<Usuario> findByNombreAndContraseña(String nombre, String contraseña);
}
