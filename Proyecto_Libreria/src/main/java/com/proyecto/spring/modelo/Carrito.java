package com.proyecto.spring.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Linea_Pedido> lineasPedido = new ArrayList<>();

    public List<Linea_Pedido> getLineasPedido() {
        return lineasPedido;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        for (Linea_Pedido linea : lineasPedido) {
            if (linea.getProducto().getId().equals(producto.getId())) {
                linea.setCantidad(linea.getCantidad() + cantidad);
                linea.setPrecio_total(linea.getCantidad() * linea.getPrecio_unitario());
                return;
            }
        }
        Linea_Pedido nuevaLinea = new Linea_Pedido();
        nuevaLinea.setProducto(producto);
        nuevaLinea.setCantidad(cantidad);
        nuevaLinea.setPrecio_unitario(producto.getPrecio());
        nuevaLinea.setPrecio_total(cantidad * producto.getPrecio());
        lineasPedido.add(nuevaLinea);
    }

    public void eliminarProducto(Long productoId) {
        lineasPedido.removeIf(linea -> linea.getProducto().getId().equals(productoId));
    }

    public void ajustarCantidad(Long productoId, int cantidad) {
        for (Linea_Pedido linea : lineasPedido) {
            if (linea.getProducto().getId().equals(productoId)) {
                linea.setCantidad(cantidad);
                linea.setPrecio_total(cantidad * linea.getPrecio_unitario());
                return;
            }
        }
    }

    public double getTotal() {
        return lineasPedido.stream().mapToDouble(Linea_Pedido::getPrecio_total).sum();
    }
}
