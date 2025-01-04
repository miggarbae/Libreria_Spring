package com.proyecto.spring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.modelo.Carrito;
import com.proyecto.spring.modelo.Linea_Pedido;
import com.proyecto.spring.modelo.Pedido;
import com.proyecto.spring.modelo.Usuario;
import com.proyecto.spring.repositorio.PedidoRepositorio;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private CarritoService carritoService;

    public Pedido finalizarPedido(Usuario usuario) {
        Carrito carrito = carritoService.getCarrito();
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setTotal(carrito.getTotal());
        pedido.setLineasPedido(carrito.getLineasPedido());
        for (Linea_Pedido linea : carrito.getLineasPedido()) {
            linea.setPedido(pedido);
        }
        return pedidoRepositorio.save(pedido);
    }
}
