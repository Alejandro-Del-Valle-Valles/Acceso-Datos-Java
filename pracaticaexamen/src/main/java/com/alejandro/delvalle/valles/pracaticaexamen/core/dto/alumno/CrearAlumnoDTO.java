package com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CrearAlumnoDTO {

    @NotNull(message = "El nombre no puede ser nulo.")
    @NotBlank(message = "El nombre no puede estar en blanco.")
    @Size(min = 3, max = 30, message = "El nombre debe ocupar entre 3 y 30 caracteres.")
    private String nombre;

    @NotNull(message = "La fecha no puede ser nula")
    @Past(message = "La fecha no puede ser presente ni futura.")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El nombre instituto no puede ser nulo.")
    @NotBlank(message = "El nombre del instituto no puede estar vacío.")
    @Size(min = 5, max = 50, message = "El nombre del instituto debe tener entre 5 y 50 caracteres.")
    private String nombreInstituto;

    @NotNull(message = "La ubicacion del instituo no puede ser nula")
    @NotBlank(message = "La ubicacion del instituo no puede estar vacía.")
    @Size(min = 5, max = 50, message = "La ubicacion del instituto debe contener entre 5 y 50 caracteres.")
    private String ubicacionInstituto;

    public CrearAlumnoDTO(String nombre, LocalDate fechaNacimiento, String nombreInstituto, String ubicacionInstituto) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreInstituto = nombreInstituto;
        this.ubicacionInstituto = ubicacionInstituto;
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

    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    public String getUbicacionInstituto() {
        return ubicacionInstituto;
    }

    public void setUbicacionInstituto(String ubicacionInstituto) {
        this.ubicacionInstituto = ubicacionInstituto;
    }
}
