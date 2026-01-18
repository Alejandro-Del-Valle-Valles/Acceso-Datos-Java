package com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public class AlumnoDTO {

    @NotBlank
    @NotNull
    @Size(min = 3, max = 30)
    private String nombre;

    @PastOrPresent
    @NotNull
    private LocalDate fechaNacimiento;

    private UUID carnet;

    @NotBlank
    @NotNull
    @Size(min = 5, max = 50)
    private String instituo; //Nombre + Localización

    public AlumnoDTO(String nombre, LocalDate fechaNacimiento, UUID carnet, String instituo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.carnet = carnet;
        this.instituo = instituo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
}
