package com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.enums.Colores;

public class CarnetDTO {

    private Colores color;
    private AlumnoDTO alumno;

    public CarnetDTO(Colores color, AlumnoDTO alumno) {
        this.color = color;
        this.alumno = alumno;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }
}
