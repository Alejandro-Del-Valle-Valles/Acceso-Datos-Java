package com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet;

import com.alejandro.delvalle.valles.pracaticaexamen.core.enums.Colores;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public class CrearCarnetDTO {

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El color no puede ser nulo.")
    private Colores color;

    public CrearCarnetDTO(Colores color) {
        this.color = color;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }
}
