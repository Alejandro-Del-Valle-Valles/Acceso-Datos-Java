package com.alejandro.delvalle.valles.pracaticaexamen.core.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Set;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank(message = "El nombre de la asignatura no puede estar vacío.")
    @Column(unique = true)
    @Size(min = 3, max = 30)
    private String nombre;

    @ManyToMany(mappedBy = "asignaturas")
    private Set<@Valid Alumno> alumnos;

    public Asignatura() {}

    public Asignatura(String nombre, Set<@Valid Alumno> alumnos) {
        this.alumnos = alumnos;
        this.nombre = nombre;
    }

    public Asignatura(Integer id, String nombre, Set<@Valid Alumno> alumnos) {
        this(nombre, alumnos);
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

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
