package com.proyecto.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.modelo.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
