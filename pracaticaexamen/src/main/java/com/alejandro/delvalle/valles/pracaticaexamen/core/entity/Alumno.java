package com.alejandro.delvalle.valles.pracaticaexamen.core.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Alumno  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @NotNull(message = "El alumno tiene que tener fecha de nacimiento.")
    @PastOrPresent(message = "La fecha de nacimiento no puede ser posterior a hoy.")
    private LocalDate fechaNacimiento;

    @OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL)
    private @Valid Carnet carnet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "instituo_id", nullable = false)
    @NotNull(message = "El alumno tiene que estar en un isntituto.")
    private @Valid Instituto instituto;

    @ManyToMany
    @JoinTable(
        name = "alumno-asignatura",
        joinColumns = @JoinColumn(name = "alumno_id"),
        inverseJoinColumns = @JoinColumn(name = "asignatura_id")
    )
    private Set<@Valid Asignatura> asignaturas;

    public Alumno() {}

    public Alumno(String nombre, LocalDate fecha_nacimiento, Carnet carnet, Instituto instituto, Set<@Valid Asignatura> asignaturas) {
        this.nombre = nombre;
        this.fechaNacimiento = fecha_nacimiento;
        this.carnet = carnet;
        this.instituto = instituto;
        this.asignaturas = asignaturas;
    }

    public Alumno(Integer id, String nombre, LocalDate fecha_nacimiento, Carnet carnet, Instituto instituto, Set<@Valid Asignatura> asignaturas) {
        this(nombre, fecha_nacimiento, carnet, instituto, asignaturas);
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

    public LocalDate getFecha_nacimiento() {
        return fechaNacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fechaNacimiento = fecha_nacimiento;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(id, alumno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
