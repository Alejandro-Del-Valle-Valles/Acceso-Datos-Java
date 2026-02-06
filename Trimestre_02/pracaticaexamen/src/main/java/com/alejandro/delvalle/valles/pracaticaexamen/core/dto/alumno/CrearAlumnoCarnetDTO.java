package com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet.CrearCarnetDTO;

import java.time.LocalDate;

public class CrearAlumnoCarnetDTO extends CrearAlumnoDTO{

    private CrearCarnetDTO carnet;

    public CrearAlumnoCarnetDTO(String nombre, LocalDate fechaNacimiento, String nombreInstituto, String ubicacionInstituto, CrearCarnetDTO carnet) {
        super(nombre, fechaNacimiento, nombreInstituto, ubicacionInstituto);
        this.carnet = carnet;
    }

    public CrearCarnetDTO getCarnet() {
        return carnet;
    }

    public void setCarnet(CrearCarnetDTO carnet) {
        this.carnet = carnet;
    }
}
