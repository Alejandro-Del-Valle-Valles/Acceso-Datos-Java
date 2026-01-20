package com.alejandro.delvalle.valles.pracaticaexamen.core.dto.asignatura;

import java.util.List;

public class AsignaturaResumenDTO {

    private String nombre;
    private Integer alumnosCursando;

    public AsignaturaResumenDTO(String nombre, Integer alumnosCursando) {
        this.nombre = nombre;
        this.alumnosCursando = alumnosCursando;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAlumnosCursando() {
        return alumnosCursando;
    }

    public void setAlumnosCursando(Integer alumnosCursando) {
        this.alumnosCursando = alumnosCursando;
    }
}
