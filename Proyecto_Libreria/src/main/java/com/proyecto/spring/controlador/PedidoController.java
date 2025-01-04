package com.proyecto.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyecto.spring.modelo.Pedido;
import com.proyecto.spring.modelo.Usuario;
import com.proyecto.spring.servicio.PedidoService;
import com.proyecto.spring.servicio.UsuarioService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/finalizar")
    public Pedido finalizarPedido(@RequestParam Long usuarioId) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        return pedidoService.finalizarPedido(usuario);
    }
}
