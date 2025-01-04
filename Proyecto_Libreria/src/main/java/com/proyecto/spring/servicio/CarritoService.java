package com.proyecto.spring.servicio;

import org.springframework.stereotype.Service;
import com.proyecto.spring.modelo.Carrito;
import com.proyecto.spring.modelo.Producto;

@Service
public class CarritoService {
    private Carrito carrito = new Carrito();

    public Carrito getCarrito() {
        return carrito;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        carrito.agregarProducto(producto, cantidad);
    }

    public void eliminarProducto(Long productoId) {
        carrito.eliminarProducto(productoId);
    }

    public void ajustarCantidad(Long productoId, int cantidad) {
        carrito.ajustarCantidad(productoId, cantidad);
    }

    public double getTotal() {
        return carrito.getTotal();
    }
}
