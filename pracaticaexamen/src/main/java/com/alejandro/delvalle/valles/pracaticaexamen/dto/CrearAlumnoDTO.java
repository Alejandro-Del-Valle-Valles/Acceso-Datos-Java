package com.alejandro.delvalle.valles.pracaticaexamen.dto;

import java.time.LocalDate;
import java.util.Set;

public class CrearAlumnoDTO {
    private String nombre;
    private LocalDate fecha_nacimiento;
    private Integer instituo;
    private Set<String> asignaturas;

    public CrearAlumnoDTO(String nombre, LocalDate fecha_nacimiento, Integer instituo, Set<String> asignaturas) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.instituo = instituo;
        this.asignaturas = asignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getInstituo() {
        return instituo;
    }

    public void setInstituo(Integer instituo) {
        this.instituo = instituo;
    }

    public Set<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<String> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
