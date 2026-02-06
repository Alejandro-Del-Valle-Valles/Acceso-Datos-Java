package com.alejandro.delvalle.valles.pracaticaexamen.core.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Alumno  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 30)
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
    private List<@Valid Asignatura> asignaturas;

    public Alumno() {}

    public Alumno(String nombre, LocalDate fecha_nacimiento, Instituto instituto, List<@Valid Asignatura> asignaturas) {
        this.nombre = nombre;
        this.fechaNacimiento = fecha_nacimiento;
        this.instituto = instituto;
        this.asignaturas = asignaturas;
    }

    public Alumno(String nombre, LocalDate fecha_nacimiento, Carnet carnet, Instituto instituto, List<@Valid Asignatura> asignaturas) {
        this(nombre, fecha_nacimiento, instituto, asignaturas);
        this.carnet = carnet;
    }

    public Alumno(Integer id, String nombre, LocalDate fecha_nacimiento, Carnet carnet, Instituto instituto, List<@Valid Asignatura> asignaturas) {
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

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void addAsignatura(Asignatura asignatura) {
        if(!asignaturas.contains(asignatura)) this.asignaturas.add(asignatura);
    }

    public void removeAsignatura(Asignatura asignatura) {
        if(asignaturas.contains(asignatura)) this.asignaturas.remove(asignatura);
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
