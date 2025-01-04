package com.proyecto.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.modelo.Producto;
import com.proyecto.spring.servicio.ProductoService;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> buscarProductos(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Double minPrecio,
            @RequestParam(required = false) Double maxPrecio) {

        return productoService.buscarPorFiltros(
                categoria != null ? categoria : "",
                nombre != null ? nombre : "",
                minPrecio != null ? minPrecio : 0,
                maxPrecio != null ? maxPrecio : Double.MAX_VALUE);
    }
}
