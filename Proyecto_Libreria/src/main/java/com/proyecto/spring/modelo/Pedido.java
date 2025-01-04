package com.proyecto.spring.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    private Long id;
	private int id_pedido;
	private int id_usuario;
	private LocalDateTime fecha_pedido = LocalDateTime.now();
	private double total;
	private Estado estado;
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", id_pedido=" + id_pedido + ", id_usuario=" + id_usuario + ", fecha_pedido=" + fecha_pedido
				+ ", total=" + total + ", estado=" + estado + "]";
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public LocalDateTime getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(LocalDateTime fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
