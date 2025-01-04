package com.proyecto.spring.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaPedido;
    private double total;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido")
    private List<Linea_Pedido> lineasPedido;

    public Pedido() {
        this.fechaPedido = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Linea_Pedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(List<Linea_Pedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }
}
