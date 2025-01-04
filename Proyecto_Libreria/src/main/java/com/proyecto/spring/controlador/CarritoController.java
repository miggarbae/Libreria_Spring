package com.proyecto.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyecto.spring.modelo.Carrito;
import com.proyecto.spring.modelo.Producto;
import com.proyecto.spring.servicio.CarritoService;
import com.proyecto.spring.servicio.ProductoService;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Carrito verCarrito() {
        return carritoService.getCarrito();
    }

    @PostMapping("/agregar")
    public void agregarProducto(@RequestParam Long productoId, @RequestParam int cantidad) {
        Producto producto = productoService.buscarPorId(productoId);
        carritoService.agregarProducto(producto, cantidad);
    }

    @PostMapping("/eliminar")
    public void eliminarProducto(@RequestParam Long productoId) {
        carritoService.eliminarProducto(productoId);
    }

    @PostMapping("/ajustar")
    public void ajustarCantidad(@RequestParam Long productoId, @RequestParam int cantidad) {
        carritoService.ajustarCantidad(productoId, cantidad);
    }

    @GetMapping("/total")
    public double obtenerTotal() {
        return carritoService.getTotal();
    }
}
