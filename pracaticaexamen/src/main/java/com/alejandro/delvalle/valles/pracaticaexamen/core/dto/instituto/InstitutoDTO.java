package com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InstitutoDTO {

    @NotNull(message = "El nombre del instituo no puede ser nulo")
    @NotBlank(message = "El nombre del instituo no puede estar en blanco")
    @Size(min = 5, max = 50, message = "El nombre debe ocupar entre 5 y 50 caracteres.")
    private String nombre;

    @NotNull
    @NotBlank(message = "La ubicación del instituo no puede estar en blanco.")
    @Size(min = 5, max = 50)
    private String ubicacion;

    public InstitutoDTO(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
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
}
