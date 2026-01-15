package com.alejandro.delvalle.valles.pracaticaexamen.dto;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class AlumnoResumenDTO {

    private String nombre;
    private LocalDate fecha_nacimiento;
    private UUID carnet;
    private String instituo;
    private Set<String> asignaturas;

    public AlumnoResumenDTO(String nombre, LocalDate fecha_nacimiento, UUID carnet, String instituo, Set<String> asignaturas) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.carnet = carnet;
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

    public UUID getCarnet() {
        return carnet;
    }

    public void setCarnet(UUID carnet) {
        this.carnet = carnet;
    }

    public String getInstituo() {
        return instituo;
    }

    public void setInstituo(String instituo) {
        this.instituo = instituo;
    }

    public Set<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<String> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
