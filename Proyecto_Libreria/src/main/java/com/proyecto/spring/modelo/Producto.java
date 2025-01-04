package com.proyecto.spring.modelo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    private double precio;
    private String descripcion;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaPublicacion;

    private String idioma;
    private String editorial;
    private String imagen;

    @ManyToMany(mappedBy = "productos")
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "producto")
    private List<Linea_Pedido> lineasPedido;

    // Default constructor
    public Producto() {
    }

    public Producto(String nombre, String categoria, double precio, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Producto(Long id, String nombre, String categoria, double precio, String descripcion, LocalDate fechaPublicacion,
            String idioma, String editorial, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.idioma = idioma;
        this.editorial = editorial;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void añadirCategoria(Categoria categoriaNueva) {
        categorias.add(categoriaNueva);
    }

    public void borrarCategoria(Categoria categoriaVieja) {
        categorias.remove(categoriaVieja);
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio
                + ", descripcion=" + descripcion + ", fechaPublicacion=" + fechaPublicacion + ", idioma=" + idioma
                + ", editorial=" + editorial + ", imagen=" + imagen + "]";
    }
}
