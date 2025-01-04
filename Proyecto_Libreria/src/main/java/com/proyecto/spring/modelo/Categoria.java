package com.proyecto.spring.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Categoria {
	@Id
	private int id_categoria;
	
	private String nombre_categoria;
	private String descripcion;
	
	@ManyToMany
	private List<Producto> productos;
	
	public Categoria(int id_categoria, String nombre_categoria, String descripcion) {
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
		this.descripcion = descripcion;
	}
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void añadirProducto(Producto productoNuevo) {
		productos.add(productoNuevo);
		productoNuevo.añadirCategoria(this); //este this hace referencia a la categoria sobre la que estoy trabajando y la vinculas
	}
	
	public void borrarProducto(Producto productoViejo) {
		productos.remove(productoViejo);
		productoViejo.borrarCategoria(this);
	}
	
	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", nombre_categoria=" + nombre_categoria + ", descripcion="
				+ descripcion + "]";
	}
}
