package com.proyecto.spring.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    
    private String nombre;
    private String email;
    private String direccion;
    private String contraseña;
    private int telefono;
    private Rol rol;

    // Default constructor
    public Usuario() {
    }

    public Usuario(String nombre, String email, String direccion, String contraseña, int telefono, Rol rol) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.rol = rol;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", email=" + email + ", direccion="
                + direccion + ", contraseña=" + contraseña + ", telefono=" + telefono + ", rol=" + rol + "]";
    }
}
