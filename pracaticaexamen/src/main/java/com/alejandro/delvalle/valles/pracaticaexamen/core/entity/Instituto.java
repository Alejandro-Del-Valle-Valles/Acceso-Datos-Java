package com.alejandro.delvalle.valles.pracaticaexamen.core.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.Set;

@Entity
public class Instituto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del instituto no puede estar en blanco.")
    private String nombre;

    @NotBlank(message = "La ubicación del instituo no puede estar en blanco.")
    private String ubicacion;

    @OneToMany(mappedBy = "instituto", cascade = CascadeType.ALL)
    private Set<@Valid Alumno> alumnos;

    public Instituto() {}

    public Instituto(String nombre, String ubicacion) {}

    public Instituto(Integer id, String nombre, String ubicacion) {
        this(nombre, ubicacion);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Instituto instituto = (Instituto) o;
        return Objects.equals(id, instituto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
