package com.alejandro.delvalle.valles.pracaticaexamen.adapter;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Asignatura;
import com.alejandro.delvalle.valles.pracaticaexamen.dto.AlumnoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.dto.AlumnoResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.dto.CrearAlumnoDTO;

import java.util.stream.Collectors;

public class AlumnoAdapter {

    public static AlumnoDTO toDTO(Alumno alumno) {
        return new AlumnoDTO(alumno.getNombre(), alumno.getFecha_nacimiento(),
                alumno.getCarnet().getId(),
                String.format("%s, %s", alumno.getInstituto().getNombre(), alumno.getInstituto().getUbicacion()));
    }

    public static AlumnoResumenDTO toAlumnoResumenDTO(Alumno alumno) {
        return new AlumnoResumenDTO(
                alumno.getNombre(),
                alumno.getFecha_nacimiento(),
                alumno.getCarnet().getId(),
                String.format("%s, %s", alumno.getInstituto().getNombre(), alumno.getInstituto().getUbicacion()),
                alumno.getAsignaturas().stream()
                        .map(Asignatura::getNombre)
                        .collect(Collectors.toSet())
        );
    }

    public static CrearAlumnoDTO toCrearAlumnoDTO(Alumno alumno) {
        return new CrearAlumnoDTO(
                alumno.getNombre(),
                alumno.getFecha_nacimiento(),
                alumno.getInstituto().getId(),
                alumno.getAsignaturas().stream()
                        .map(Asignatura::getNombre)
                        .collect(Collectors.toSet())
        );
    }
}
