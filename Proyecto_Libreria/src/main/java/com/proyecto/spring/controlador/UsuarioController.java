package com.proyecto.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.spring.modelo.Usuario;
import com.proyecto.spring.servicio.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        usuarioService.registrarUsuario(usuario);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario registrado exitosamente. Por favor, inicia sesión.");
        return "redirect:/login";
    }
}
