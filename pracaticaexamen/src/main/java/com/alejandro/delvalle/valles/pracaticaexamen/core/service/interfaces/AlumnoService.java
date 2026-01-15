package com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;

import java.time.LocalDate;
import java.util.List;

public interface AlumnoService {

    List<Alumno> getAll();
    List<Alumno> getAlumnosByNombre(String nombre);
    List<Alumno> getAlumnosByFechaNacimiento(LocalDate fecha);
    List<Alumno> getAlumnosByCentroNombreUbicacion(String nombre, String ubicacion);
    List<Alumno> getByAsignaturaNombre(String asignatura);
    Alumno getAlumnoById(int id);
}
