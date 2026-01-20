package com.alejandro.delvalle.valles.pracaticaexamen.adapter;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.asignatura.AsignaturaResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Asignatura;

public class AsignaturaAdapater {

    public static AsignaturaResumenDTO toResumenDTO(Asignatura asignatura) {
        return new AsignaturaResumenDTO(asignatura.getNombre(), asignatura.getAlumnos().size());
    }
}
