package com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.CrearAlumnoCarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.CrearAlumnoDTO;

import java.time.LocalDate;
import java.util.List;

public interface AlumnoService {

    List<AlumnoDTO> getAll();
    List<AlumnoDTO> getAlumnosByNombre(String nombre);
    List<AlumnoDTO> getAlumnosByFechaNacimiento(LocalDate fecha);
    List<AlumnoDTO> getAlumnosByFechaNacimientoOrdered(boolean asc);
    List<AlumnoDTO> getAlumnosByInstitutoUbicacion(String ubicacion);
    List<AlumnoDTO> getAlumnosByInstitutoNombreUbicacion(String nombre, String ubicacion);
    List<AlumnoResumenDTO> getByAsignaturaNombre(String asignatura);
    AlumnoResumenDTO getById(int id);
    AlumnoDTO createAlumno(CrearAlumnoDTO alumno);
    AlumnoDTO createAlumnoCarnet(CrearAlumnoCarnetDTO alumno);
    AlumnoDTO updateAlumno(int id, CrearAlumnoDTO alumno);
    AlumnoResumenDTO deleteAlumnoById(int id);
}
