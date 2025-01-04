package com.proyecto.spring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.modelo.Producto;
import com.proyecto.spring.repositorio.ProductoRepositorio;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> buscarPorCategoria(String categoria) {
        return productoRepositorio.findByCategoria(categoria);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepositorio.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Producto> buscarPorRangoDePrecios(double minPrecio, double maxPrecio) {
        return productoRepositorio.findByPrecioBetween(minPrecio, maxPrecio);
    }

    public List<Producto> buscarPorFiltros(String categoria, String nombre, double minPrecio, double maxPrecio) {
        Specification<Producto> spec = (root, query, criteriaBuilder) -> {
            Predicate p = criteriaBuilder.conjunction();
            if (categoria != null && !categoria.isEmpty()) {
                p = criteriaBuilder.and(p, criteriaBuilder.equal(root.get("categoria"), categoria));
            }
            if (nombre != null && !nombre.isEmpty()) {
                p = criteriaBuilder.and(p, criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
            }
            if (minPrecio >= 0) {
                p = criteriaBuilder.and(p, criteriaBuilder.greaterThanOrEqualTo(root.get("precio"), minPrecio));
            }
            if (maxPrecio >= 0) {
                p = criteriaBuilder.and(p, criteriaBuilder.lessThanOrEqualTo(root.get("precio"), maxPrecio));
            }
            return p;
        };
        return productoRepositorio.findAll(spec);
    }

    public Producto buscarPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }
}
