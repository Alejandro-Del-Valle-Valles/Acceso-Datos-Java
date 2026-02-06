package com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class InstitutoResumenDTO {

    @NotNull(message = "El nombre del instituo no puede ser nulo")
    @NotBlank(message = "El nombre del instituo no puede estar en blanco")
    @Size(min = 5, max = 50, message = "El nombre debe ocupar entre 5 y 50 caracteres.")
    private String nombre;

    @NotNull
    @NotBlank(message = "La ubicación del instituo no puede estar en blanco.")
    @Size(min = 5, max = 50)
    private String ubicacion;

    private List<AlumnoDTO> alumnos;

    public InstitutoResumenDTO(String nombre, String ubicacion, List<AlumnoDTO> alumnos) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.alumnos = alumnos;
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

    public List<AlumnoDTO> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoDTO> alumnos) {
        this.alumnos = alumnos;
    }
}
