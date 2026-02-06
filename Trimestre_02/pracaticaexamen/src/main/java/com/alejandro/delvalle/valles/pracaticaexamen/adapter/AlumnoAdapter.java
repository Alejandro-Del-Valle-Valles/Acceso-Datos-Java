package com.alejandro.delvalle.valles.pracaticaexamen.adapter;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Asignatura;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.CrearAlumnoDTO;

import java.util.UUID;
import java.util.stream.Collectors;

public class AlumnoAdapter {

    public static AlumnoDTO toDTO(Alumno alumno) {
        UUID carnet = alumno.getCarnet() == null ? null : alumno.getCarnet().getId();
        return new AlumnoDTO(alumno.getNombre(), alumno.getFecha_nacimiento(),
                carnet,
                String.format("%s, %s", alumno.getInstituto().getNombre(), alumno.getInstituto().getUbicacion()));
    }

    public static AlumnoResumenDTO toResumenDTO(Alumno alumno) {
        UUID carnet = alumno.getCarnet() == null ? null : alumno.getCarnet().getId();
        return new AlumnoResumenDTO(
                alumno.getNombre(),
                alumno.getFecha_nacimiento(),
                carnet,
                String.format("%s, %s", alumno.getInstituto().getNombre(), alumno.getInstituto().getUbicacion()),
                alumno.getAsignaturas().stream()
                        .map(Asignatura::getNombre)
                        .toList()
        );
    }

    public static CrearAlumnoDTO toCrearAlumnoDTO(Alumno alumno) {
        return new CrearAlumnoDTO(
                alumno.getNombre(),
                alumno.getFecha_nacimiento(),
                alumno.getInstituto().getNombre(),
                alumno.getInstituto().getUbicacion()
        );
    }
}
