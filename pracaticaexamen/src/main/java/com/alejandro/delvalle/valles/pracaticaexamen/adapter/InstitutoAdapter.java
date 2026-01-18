package com.alejandro.delvalle.valles.pracaticaexamen.adapter;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto.InstitutoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto.InstitutoResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Instituto;

public class InstitutoAdapter {

    public static InstitutoDTO toDTO(Instituto instituto) {
        return new InstitutoDTO(instituto.getNombre(), instituto.getUbicacion());
    }

    public static InstitutoResumenDTO toResumenDTO(Instituto instituto) {
        return new InstitutoResumenDTO(instituto.getNombre(), instituto.getUbicacion(),
                instituto.getAlumnos().stream().map(AlumnoAdapter::toDTO).toList());
    }
}
