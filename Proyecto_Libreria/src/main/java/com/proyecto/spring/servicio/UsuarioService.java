package com.proyecto.spring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.spring.modelo.Usuario;
import com.proyecto.spring.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario buscarPorId(Long id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Usuario registrarUsuario(Usuario usuario) {
        // Validate user information
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El correo es obligatorio");
        }
        if (usuario.getContraseña() == null || usuario.getContraseña().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }
        // Encode password
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        // Save user to the database
        Usuario usuarioRegistrado = usuarioRepositorio.save(usuario);

        // Send confirmation email
        String asunto = "Confirmación de registro";
        String mensaje = "Gracias por registrarte en nuestra tienda.";
        emailService.enviarCorreoConfirmacion(usuario.getEmail(), asunto, mensaje);

        return usuarioRegistrado;
    }
}
